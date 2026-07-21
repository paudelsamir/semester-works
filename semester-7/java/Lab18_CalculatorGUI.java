import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Lab18_CalculatorGUI extends JFrame implements ActionListener {

    private JTextField tf1, tf2;
    private JLabel resultLabel;

    public Lab18_CalculatorGUI() {
        setTitle("Lab 18 - Shishir Pandey (15/079, Sec A)");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(16f));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(230, 255, 230));

        JButton addBtn = new JButton("+", createIcon(Color.GREEN));
        JButton subBtn = new JButton("-", createIcon(Color.RED));
        JButton mulBtn = new JButton("*", createIcon(Color.BLUE));

        addBtn.setToolTipText("Add");
        subBtn.setToolTipText("Subtract");
        mulBtn.setToolTipText("Multiply");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Number 1:"));
        inputPanel.add(tf1);
        inputPanel.add(new JLabel("Number 2:"));
        inputPanel.add(tf2);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addBtn);
        buttonPanel.add(subBtn);
        buttonPanel.add(mulBtn);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(resultLabel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private ImageIcon createIcon(Color c) {
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(c);
        g.fillOval(2, 2, 12, 12);
        g.dispose();
        return new ImageIcon(img);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(tf1.getText());
            double b = Double.parseDouble(tf2.getText());
            double r = 0;
            String op = e.getActionCommand();
            if (op.equals("+")) r = a + b;
            else if (op.equals("-")) r = a - b;
            else if (op.equals("*")) r = a * b;
            resultLabel.setText("Result: " + r);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid input!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab18_CalculatorGUI::new);
    }
}
