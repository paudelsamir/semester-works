import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Lab21_TCPSocketServer {
    
    static final int PORT = 5000;
    
    public static void main(String[] args) {
        System.out.println("--- TCP Socket Server ---");
        System.out.println("Server waiting for connection on port " + PORT);
        
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
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
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 21 (Server)");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
