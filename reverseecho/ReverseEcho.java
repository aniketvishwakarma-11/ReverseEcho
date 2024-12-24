package reverseecho;

import java.io.*;
import java.net.*;

public class ReverseEcho extends Thread {
    Socket stk;

    public ReverseEcho(Socket st) {
        this.stk = st; // Assign the connected client socket
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
             PrintStream ps = new PrintStream(stk.getOutputStream())) {

            String msg;
            StringBuilder sb;

            do {
                msg = br.readLine();
                if (msg != null) {
                    sb = new StringBuilder(msg);
                    sb.reverse();
                    msg = sb.toString();
                    ps.println(msg);
                }
            } while (!"dne".equalsIgnoreCase(msg.trim()));
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            try {
                stk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try (ServerSocket ss = new ServerSocket(2000)) {
            System.out.println("Server is running on port 2000...");
            int count = 1;

            while (true) {
                Socket stk = ss.accept(); 
                System.out.println("Client Connected: " + count++);
                new ReverseEcho(stk).start();
            }
        }
    }
}
