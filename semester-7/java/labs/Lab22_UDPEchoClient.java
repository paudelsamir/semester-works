import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Lab22_UDPEchoClient {
    
    static final String HOST = "localhost";
    static final int PORT = 5001;
    static final int BUFFER_SIZE = 1024;
    
    public static void main(String[] args) {
        System.out.println("--- UDP Echo Client ---");
        
        try {
            DatagramSocket socket = new DatagramSocket();
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter message to send to server: ");
            String message = scanner.nextLine();
            
            InetAddress address = InetAddress.getByName(HOST);
            byte[] sendData = message.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, PORT);
            socket.send(sendPacket);
            
            System.out.println("Message sent: " + message);
            System.out.println("Waiting for echo...");
            
            byte[] receiveBuffer = new byte[BUFFER_SIZE];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);
            
            String echo = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Echo received: " + echo);
            
            socket.close();
            scanner.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 22 (Client)");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
