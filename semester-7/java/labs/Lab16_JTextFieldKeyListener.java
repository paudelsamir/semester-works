import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Lab16_JTextFieldKeyListener extends JFrame {
    
    private JTextField textField;
    
    Lab16_JTextFieldKeyListener() {
        setTitle("Numeric Digits Only");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        JLabel label = new JLabel("Enter only numeric digits (0-9):");
        panel.add(label);
        
        textField = new JTextField(20);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Handle key press
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // Handle key release
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore non-numeric keys
                }
            }
        });
        panel.add(textField);
        
        JLabel infoLabel = new JLabel("Any other key will be ignored");
        panel.add(infoLabel);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab16_JTextFieldKeyListener();
            }
        });
        
        System.out.println("=============================");
        System.out.println("Lab No.: 16");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
