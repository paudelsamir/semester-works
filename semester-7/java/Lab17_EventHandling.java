import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Separate class implementing ActionListener (way 4)
class ExternalHandler implements ActionListener {
    private JLabel label;
    public ExternalHandler(JLabel label) { this.label = label; }
    public void actionPerformed(ActionEvent e) {
        label.setText("External class handler: " + e.getActionCommand());
    }
}

public class Lab17_EventHandling extends JFrame implements ActionListener {

    private JLabel display;

    public Lab17_EventHandling() {
        setTitle("Lab 17 - Shishir Pandey (15/079, Sec A)");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JLabel("Click a button to see event handling method", SwingConstants.CENTER);
        display.setFont(display.getFont().deriveFont(14f));

        JButton btnSame = new JButton("Same Class (way 1)");
        JButton btnInner = new JButton("Inner Class (way 2)");
        JButton btnAnon = new JButton("Anonymous (way 3)");
        JButton btnExternal = new JButton("External Class (way 4)");

        // Way 1: Same class implements ActionListener
        btnSame.addActionListener(this);

        // Way 2: Inner class
        btnInner.addActionListener(new InnerHandler());

        // Way 3: Anonymous inner class
        btnAnon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("Anonymous inner class: " + e.getActionCommand());
            }
        });

        // Way 4: Separate external class
        btnExternal.addActionListener(new ExternalHandler(display));

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(btnSame);
        panel.add(btnInner);
        panel.add(btnAnon);
        panel.add(btnExternal);

        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Way 1: Same class
    public void actionPerformed(ActionEvent e) {
        display.setText("Same class handler: " + e.getActionCommand());
    }

    // Way 2: Inner class
    private class InnerHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText("Inner class handler: " + e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab17_EventHandling::new);
    }
}
