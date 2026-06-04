import java.net.MalformedURLException;
import java.net.URL;

public class Lab23_URLObject {
    
    public static void main(String[] args) {
        System.out.println("--- URL Object Handling ---\n");
        
        String urlString = "https://www.example.com/index.html?user=test";
        
        try {
            URL url = new URL(urlString);
            
            System.out.println("URL: " + urlString);
            System.out.println("------------------------------------");
            
            // Get protocol
            String protocol = url.getProtocol();
            System.out.println("Protocol: " + protocol);
            
            // Get host
            String host = url.getHost();
            System.out.println("Host: " + host);
            
            // Get file path
            String file = url.getFile();
            System.out.println("File path: " + file);
            
            // Additional information
            System.out.println("\nAdditional Information:");
            System.out.println("Port: " + url.getPort());
            System.out.println("Default Port: " + url.getDefaultPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Authority: " + url.getAuthority());
            
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 23");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
