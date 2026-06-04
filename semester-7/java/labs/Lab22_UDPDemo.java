import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Lab22_UDPDemo {
    
    static class EchoServer extends Thread {
        public void run() {
            try {
                DatagramSocket socket = new DatagramSocket(5001);
                System.out.println("--- UDP Echo Server ---");
                System.out.println("Server listening on port 5001");
                
                byte[] buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);
                
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Message received: " + message);
                
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
                System.out.println("Echo sent back to client");
                
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    static class EchoClient {
        public static void main(String[] args) {
            try {
                Thread.sleep(1000);  // Wait for server to start
                
                DatagramSocket socket = new DatagramSocket();
                System.out.println("--- UDP Echo Client ---");
                
                String message = "Hello UDP Server!";
                byte[] sendData = message.getBytes();
                
                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 5001);
                socket.send(sendPacket);
                System.out.println("Message sent: " + message);
                
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                
                String echo = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Echo received: " + echo);
                
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        // Start server
        EchoServer server = new EchoServer();
        server.start();
        
        // Give server time to start
        Thread.sleep(500);
        
        // Run client
        EchoClient.main(new String[]{});
        
        // Wait for server to finish
        server.join();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 22");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
