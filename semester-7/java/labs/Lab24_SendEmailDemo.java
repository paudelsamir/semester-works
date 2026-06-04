import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Lab 24: Send Email Using JavaMail API
 * Advanced Java Programming / CSIT-7th Semester
 * 
 * Real JavaMail Implementation:
 * - Configure SMTP server properties
 * - Create MIME email message
 * - Add sender, recipient, subject, and body
 * - Authenticate and send email via SMTP
 */
public class Lab24_SendEmailDemo {
    
    // Email Configuration
    static final String SMTP_HOST = "smtp.gmail.com";
    static final String SMTP_PORT = "587";
    static final String SENDER_EMAIL = "your-email@gmail.com";
    static final String SENDER_PASSWORD = "your-app-password";  // Use App Password for Gmail
    static final String RECIPIENT_EMAIL = "receiver@example.com";
    
    public static void main(String[] args) {
        try {
            System.out.println("=== JavaMail Email Sender ===\n");
            
            // Configure SMTP Properties
            Properties props = configureSMTPProperties();
            System.out.println("✓ SMTP Properties configured");
            
            // Create Session with Authentication
            Authenticator auth = new SMTPAuthenticator(SENDER_EMAIL, SENDER_PASSWORD);
            Session session = Session.getInstance(props, auth);
            session.setDebug(false);  // Set to true for debugging
            System.out.println("✓ Session created with authentication");
            
            // Create Message
            System.out.println("\n--- Email Details ---");
            Message message = createEmailMessage(session);
            System.out.println("✓ Email message created");
            
            // Send Email
            System.out.println("\n--- Sending Email ---");
            Transport.send(message);
            System.out.println("✓ Email sent successfully!");
            
            System.out.println("\nStatus: SENT");
            System.out.println("Timestamp: " + new java.util.Date());
            
            System.out.println("\n--- Lab Information ---");
            System.out.println("Lab No.: 24");
            System.out.println("Name: Samir Paudel");
            System.out.println("Roll No./Section: 114-079/D");
            
        } catch (MessagingException e) {
            System.err.println("✗ Email Error: " + e.getMessage());
            System.out.println("\n--- Troubleshooting ---");
            System.out.println("1. Ensure JavaMail library is in classpath");
            System.out.println("2. Check SMTP credentials and settings");
            System.out.println("3. For Gmail, enable 'Less secure app access' or use App Password");
            System.out.println("4. Verify firewall/network allows SMTP port 587");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Configure SMTP Properties
    static Properties configureSMTPProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.connectiontimeout", "5000");
        props.put("mail.smtp.timeout", "5000");
        
        System.out.println("SMTP Configuration:");
        System.out.println("  Host: " + SMTP_HOST);
        System.out.println("  Port: " + SMTP_PORT);
        System.out.println("  Authentication: Enabled");
        System.out.println("  STARTTLS: Enabled");
        
        return props;
    }
    
    // Create Email Message
    static Message createEmailMessage(Session session) throws MessagingException {
        Message message = new MimeMessage(session);
        
        message.setFrom(new InternetAddress(SENDER_EMAIL));
        message.setRecipients(Message.RecipientType.TO, 
                InternetAddress.parse(RECIPIENT_EMAIL));
        message.setSubject("Java Lab 24 - Email Test");
        
        String body = "Dear Recipient,\n\n" +
                     "This is an automated email sent using JavaMail API.\n\n" +
                     "Lab Details:\n" +
                     "Lab No.: 24\n" +
                     "Course: Advanced Java Programming\n" +
                     "Semester: 7th (CSIT)\n" +
                     "Name: Samir Paudel\n" +
                     "Roll No./Section: 114-079/D\n\n" +
                     "Best Regards,\n" +
                     "Java Application";
        
        message.setText(body);
        message.setSentDate(new java.util.Date());
        
        System.out.println("From: " + SENDER_EMAIL);
        System.out.println("To: " + RECIPIENT_EMAIL);
        System.out.println("Subject: " + message.getSubject());
        System.out.println("Message Type: MIME Text");
        
        return message;
    }
}

/**
 * Authenticator for SMTP Authentication
 */
class SMTPAuthenticator extends Authenticator {
    private String username;
    private String password;
    
    SMTPAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
