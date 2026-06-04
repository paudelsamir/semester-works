import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Lab24_SendEmail {
    
    public static void main(String[] args) {
        System.out.println("--- Email Using JavaMail API ---\n");
        
        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        // Create session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Replace with your actual email and password
                return new PasswordAuthentication("your_email@gmail.com", "your_password");
            }
        });
        
        try {
            // Create MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sender@test.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("receiver@test.com"));
            message.setSubject("Test Mail");
            message.setText("This is a test email sent using JavaMail API.\n\n" +
                    "Lab No.: 24\n" +
                    "Name: Samir Paudel\n" +
                    "Roll No./Section: 114-079/D");
            
            // Send the email
            Transport.send(message);
            
            System.out.println("Email sent successfully!");
            System.out.println("From: sender@test.com");
            System.out.println("To: receiver@test.com");
            System.out.println("Subject: Test Mail");
            System.out.println("Status: SENT");
            
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
            
            System.out.println("\nNote: To use this program with Gmail:");
            System.out.println("1. Enable 'Less secure app access' in Gmail settings");
            System.out.println("2. Or use an App Password for 2FA enabled accounts");
            System.out.println("3. Replace 'your_email@gmail.com' and 'your_password' in the code");
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 24");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
