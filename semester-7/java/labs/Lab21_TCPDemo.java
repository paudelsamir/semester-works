import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Lab21_TCPDemo {
    
    static class SimpleServer extends Thread {
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(5000);
                System.out.println("--- TCP Socket Server ---");
                System.out.println("Server waiting for connection on port 5000");
                
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getInetAddress());
                
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();
                System.out.println("Message received from client: " + message);
                
                reader.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    static class SimpleClient {
        public static void main(String[] args) {
            try {
                Thread.sleep(1000);  // Wait for server to start
                Socket socket = new Socket("localhost", 5000);
                System.out.println("--- TCP Socket Client ---");
                System.out.println("Connected to server");
                
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello from Client!");
                System.out.println("Message sent: Hello from Client!");
                
                writer.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        // Start server in background
        SimpleServer server = new SimpleServer();
        server.start();
        
        // Give server time to start
        Thread.sleep(500);
        
        // Run client
        SimpleClient.main(new String[]{});
        
        // Wait for server to finish
        server.join();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 21");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
