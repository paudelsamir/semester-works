import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Lab15_ComprehensiveSwing extends JFrame {

    public Lab15_ComprehensiveSwing() {
        setTitle("Lab 15 - Shishir Pandey (15/079, Sec A)");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Frame icon
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 16, 16);
        g2d.dispose();
        setIconImage(img);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Label with icon
        BufferedImage iconImg = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = iconImg.createGraphics();
        g.setColor(Color.ORANGE);
        g.fillOval(4, 4, 24, 24);
        g.dispose();
        JLabel iconLabel = new JLabel(new ImageIcon(iconImg));
        panel.add(new JLabel("Icon Label:"));
        panel.add(iconLabel);

        // Name label
        panel.add(new JLabel("Name Label:"));
        panel.add(new JLabel("Shishir Pandey", SwingConstants.CENTER));

        // TextField with colorful border and tooltip
        panel.add(new JLabel("TextField:"));
        JTextField tf = new JTextField("Type here");
        tf.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
        tf.setToolTipText("This is a text field with a magenta border");
        panel.add(tf);

        // TextArea with scrollbars
        panel.add(new JLabel("TextArea:"));
        JTextArea ta = new JTextArea(4, 15);
        ta.setText("Multi-line\ntext area");
        panel.add(new JScrollPane(ta));

        // CheckBox
        panel.add(new JLabel("CheckBox:"));
        panel.add(new JCheckBox("I agree"));

        // PasswordField
        panel.add(new JLabel("Password:"));
        panel.add(new JPasswordField("secret"));

        // RadioButton
        panel.add(new JLabel("RadioButton:"));
        JRadioButton rb = new JRadioButton("Male", true);
        panel.add(rb);

        // PushButton
        panel.add(new JLabel("PushButton:"));
        JButton btn = new JButton("Click Me");
        btn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Button clicked!"));
        panel.add(btn);

        // ComboBox
        panel.add(new JLabel("ComboBox:"));
        panel.add(new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"}));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab15_ComprehensiveSwing::new);
    }
}
