import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) throws Exception {
        try (Socket stk = new Socket("localhost", 2000);
             BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
             PrintStream ps = new PrintStream(stk.getOutputStream())) {

            String msg;
            System.out.println("Enter messages (type 'dne' to terminate):");
            do {
                msg = keyb.readLine();
                ps.println(msg); // Send the message to the server
                msg = br.readLine(); // Read the reversed message from the server
                System.out.println("From Server: " + msg);
            } while (!"dne".equalsIgnoreCase(msg.trim())); // Exit on "dne"
        }
    }
}
