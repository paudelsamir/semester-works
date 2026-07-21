import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Lab24_SendEmail {

    public static void main(String[] args) {
        System.out.println("=== JavaMail Email Sender ===\n");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        System.out.println("SMTP Configuration:");
        System.out.println("  Host: " + props.getProperty("mail.smtp.host"));
        System.out.println("  Port: " + props.getProperty("mail.smtp.port"));
        System.out.println("  Authentication: " + props.getProperty("mail.smtp.auth"));
        System.out.println("  STARTTLS: " + props.getProperty("mail.smtp.starttls.enable"));

        Session session = Session.getInstance(props);
        System.out.println("\n✓ Session object created (assume properly configured)");

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sender@test.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("receiver@test.com"));
            message.setSubject("Test Mail");
            message.setText("This is a test email sent using JavaMail API.");

            System.out.println("\n--- Email Details ---");
            System.out.println("From:    sender@test.com");
            System.out.println("To:      receiver@test.com");
            System.out.println("Subject: " + message.getSubject());
            System.out.println("Body:    This is a test email sent using JavaMail API.");

            System.out.println("\n--- Status ---");
            System.out.println("✓ MimeMessage created successfully");
            System.out.println("✓ Ready to send (Transport.send() not invoked as per spec)");

        } catch (MessagingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=============================");
        System.out.println("Lab No.: 24");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
