import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab12_SwingColorButtons extends JFrame {
    
    private JButton redButton;
    private JButton blueButton;
    private JButton greenButton;
    
    Lab12_SwingColorButtons() {
        setTitle("Colored Buttons");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        // Red Button
        redButton = new JButton("RED");
        redButton.setFont(new Font("Arial", Font.BOLD, 14));
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redButton.setBackground(Color.RED);
                redButton.setOpaque(true);
                redButton.setBorderPainted(true);
            }
        });
        panel.add(redButton);
        
        // Blue Button
        blueButton = new JButton("BLUE");
        blueButton.setFont(new Font("Arial", Font.BOLD, 14));
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blueButton.setBackground(Color.BLUE);
                blueButton.setOpaque(true);
                blueButton.setBorderPainted(true);
                blueButton.setForeground(Color.WHITE);
            }
        });
        panel.add(blueButton);
        
        // Green Button
        greenButton = new JButton("GREEN");
        greenButton.setFont(new Font("Arial", Font.BOLD, 14));
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greenButton.setBackground(Color.GREEN);
                greenButton.setOpaque(true);
                greenButton.setBorderPainted(true);
            }
        });
        panel.add(greenButton);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab12_SwingColorButtons();
            }
        });
        
        System.out.println("=============================");
        System.out.println("Lab No.: 12");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
