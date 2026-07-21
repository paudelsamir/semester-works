import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab23_Dialogs extends JFrame {

    public Lab23_Dialogs() {
        setTitle("Lab 23 - Shishir Pandey (15/079, Sec A)");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JToolBar toolbar = new JToolBar();
        JButton modalBtn = new JButton("Modal Dialog");
        JButton modelessBtn = new JButton("Modelless Dialog");

        modalBtn.addActionListener(e -> showDialog(true));
        modelessBtn.addActionListener(e -> showDialog(false));

        toolbar.add(modalBtn);
        toolbar.add(modelessBtn);

        JLabel info = new JLabel("Click toolbar buttons to open dialogs", SwingConstants.CENTER);
        info.setFont(info.getFont().deriveFont(16f));

        add(toolbar, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        setVisible(true);
    }

    private void showDialog(boolean modal) {
        JDialog dialog = new JDialog(this, modal ? "Modal Dialog" : "Modelless Dialog", modal);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);

        JLabel msg = new JLabel(modal ? "This is a MODAL dialog" : "This is a MODELLESS dialog", SwingConstants.CENTER);
        JButton close = new JButton("Close");
        close.addActionListener(e -> dialog.dispose());

        dialog.setLayout(new BorderLayout());
        dialog.add(msg, BorderLayout.CENTER);
        dialog.add(close, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab23_Dialogs::new);
    }
}
