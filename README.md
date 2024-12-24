
# ReverseEcho Project

This project demonstrates a simple client-server communication using Java. The server receives messages from the client, reverses them, and sends the reversed messages back. The communication ends when the client sends the message `dne` (which stands for "end").

## Project Structure

```
/reverseecho
    ├── ReverseEcho.java  (Server code)
/ Client.java       (Client code)
```

### 1. **ReverseEcho.java** (Server)
This class implements the server-side logic. The server listens for client connections on port `2000`, reads messages from the client, reverses them, 
and sends the reversed message back to the client.

### 2. **Client.java** (Client)
This class implements the client-side logic. The client connects to the server at `localhost` on port `2000`, sends a message to the server, 
and displays the reversed message received from the server. The client stops when the message `dne` is entered.

## How to Run

### Server Side:
1. Open a terminal or command prompt.
2. Navigate to the directory containing `ReverseEcho.java`.
3. Compile the server code:
   ```bash
   javac ReverseEcho.java
   ```
4. Run the server:
   ```bash
   java ReverseEcho
   ```

### Client Side:
1. Open a terminal or command prompt.
2. Navigate to the directory containing `Client.java`.
3. Compile the client code:
   ```bash
   javac Client.java
   ```
4. Run the client:
   ```bash
   java Client
   ```

## Usage

1. The client will prompt you to enter a message.
2. The server will reverse the message and send it back to the client.
3. The process repeats until the client sends the message `dne`.

## Example

### Server Console Output:
```
Server is running on port 2000...
Client Connected: 1
```

### Client Console Output:
```
Enter messages (type 'end' to terminate):
Hello
From Server: olleH
Hii
From Server: iiH
dne
```

.
