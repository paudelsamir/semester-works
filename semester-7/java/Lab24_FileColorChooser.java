import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab24_FileColorChooser extends JFrame implements ActionListener {

    private JLabel display;

    public Lab24_FileColorChooser() {
        setTitle("Lab 24 - Shishir Pandey (15/079, Sec A)");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JLabel("Choose a file or color using the buttons", SwingConstants.CENTER);
        display.setOpaque(true);
        display.setBackground(Color.WHITE);
        display.setFont(display.getFont().deriveFont(14f));

        JButton fileBtn = new JButton("File Chooser");
        JButton colorBtn = new JButton("Color Chooser");

        fileBtn.addActionListener(this);
        colorBtn.addActionListener(this);
        fileBtn.setActionCommand("file");
        colorBtn.setActionCommand("color");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        btnPanel.add(fileBtn);
        btnPanel.add(colorBtn);

        add(btnPanel, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("file")) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                display.setText("Selected file: " + fc.getSelectedFile().getAbsolutePath());
            }
        } else {
            Color c = JColorChooser.showDialog(this, "Pick a Color", display.getBackground());
            if (c != null) {
                display.setBackground(c);
                display.setText("Selected color: RGB(" + c.getRed() + "," + c.getGreen() + "," + c.getBlue() + ")");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab24_FileColorChooser::new);
    }
}
