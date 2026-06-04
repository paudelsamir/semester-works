import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Lab21_TCPSocketClient {
    
    static final String HOST = "localhost";
    static final int PORT = 5000;
    
    public static void main(String[] args) {
        System.out.println("--- TCP Socket Client ---");
        
        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Connected to server at " + HOST + ":" + PORT);
            
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter message to send to server: ");
            String message = scanner.nextLine();
            
            writer.println(message);
            System.out.println("Message sent: " + message);
            
            writer.close();
            socket.close();
            scanner.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 21 (Client)");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
