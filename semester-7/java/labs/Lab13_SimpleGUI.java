import javax.swing.*;

public class Lab13_SimpleGUI extends JFrame {
    
    private JTextField textField;
    private JButton button;
    
    Lab13_SimpleGUI() {
        setTitle("Simple GUI");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        textField = new JTextField("Hello World", 20);
        textField.setEditable(false);
        panel.add(textField);
        
        button = new JButton("Click Me");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(Lab13_SimpleGUI.this,
                    "Output: " + textField.getText(),
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(button);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab13_SimpleGUI();
            }
        });
        
        System.out.println("=============================");
        System.out.println("Lab No.: 13");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
