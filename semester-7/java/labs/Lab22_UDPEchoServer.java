import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Lab22_UDPEchoServer {
    
    static final int PORT = 5001;
    static final int BUFFER_SIZE = 1024;
    
    public static void main(String[] args) {
        System.out.println("--- UDP Echo Server ---");
        System.out.println("Server listening on port " + PORT);
        
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            byte[] buffer = new byte[BUFFER_SIZE];
            
            System.out.println("Waiting for client message...");
            
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);
            
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message received from " + receivePacket.getAddress() + ":" + 
                    receivePacket.getPort());
            System.out.println("Message: " + receivedMessage);
            
            // Send echo back
            byte[] sendData = receivedMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                    receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);
            
            System.out.println("Echo sent back to client");
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 22 (Server)");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
