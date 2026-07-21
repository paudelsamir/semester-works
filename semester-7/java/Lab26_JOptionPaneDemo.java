import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab26_JOptionPaneDemo extends JFrame implements ActionListener {

    public Lab26_JOptionPaneDemo() {
        setTitle("Lab 26 - Shishir Pandey (15/079, Sec A)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] labels = {
            "Information", "Question", "Error", "Warning",
            "Confirm", "Input", "Option"
        };
        String[] cmds = {
            "info", "question", "error", "warning",
            "confirm", "input", "option"
        };

        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i] + " Dialog:", SwingConstants.RIGHT));
            JButton btn = new JButton("Show " + labels[i]);
            btn.setActionCommand(cmds[i]);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "info":
                JOptionPane.showMessageDialog(this, "This is an information message.", "Information", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "question":
                JOptionPane.showMessageDialog(this, "Is this helpful?", "Question", JOptionPane.QUESTION_MESSAGE);
                break;
            case "error":
                JOptionPane.showMessageDialog(this, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "warning":
                JOptionPane.showMessageDialog(this, "Proceed with caution.", "Warning", JOptionPane.WARNING_MESSAGE);
                break;
            case "confirm":
                int r = JOptionPane.showConfirmDialog(this, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                JOptionPane.showMessageDialog(this, "You chose option: " + r, "Result", JOptionPane.PLAIN_MESSAGE);
                break;
            case "input":
                String input = JOptionPane.showInputDialog(this, "Enter your name:", "Input", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(this, "Hello, " + (input != null ? input : "null") + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "option":
                String[] options = {"Option A", "Option B", "Cancel"};
                int choice = JOptionPane.showOptionDialog(this, "Pick an option:", "Option Dialog",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                JOptionPane.showMessageDialog(this, "You picked: " + (choice >= 0 ? options[choice] : "Canceled"), "Result", JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab26_JOptionPaneDemo::new);
    }
}
