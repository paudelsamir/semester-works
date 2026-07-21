import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab19_EventTypes extends JFrame {

    private JTextArea log;

    public Lab19_EventTypes() {
        setTitle("Lab 19 - Shishir Pandey (15/079, Sec A)");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        log = new JTextArea(8, 50);
        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("WindowEvent", createWindowEventPanel());
        tabs.addTab("ItemEvent", createItemEventPanel());
        tabs.addTab("FocusEvent", createFocusEventPanel());
        tabs.addTab("MouseEvent", createMouseEventPanel());
        tabs.addTab("KeyEvent", createKeyEventPanel());

        add(scrollPane, BorderLayout.SOUTH);
        add(tabs, BorderLayout.CENTER);
        setVisible(true);
    }

    private void log(String msg) {
        log.append(msg + "\n");
    }

    // ─── WindowEvent ───
    private JPanel createWindowEventPanel() {
        JPanel p = new JPanel();
        JButton btn = new JButton("Open WindowEvent Window");
        btn.addActionListener(e -> {
            JFrame wf = new JFrame("WindowEvent Demo");
            wf.setSize(300, 200);
            wf.setLocationRelativeTo(null);
            wf.add(new JLabel("Try closing / iconifying this window", SwingConstants.CENTER));
            wf.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) { log("WindowEvent: opened"); }
                public void windowClosing(WindowEvent e) {
                    log("WindowEvent: closing");
                    wf.dispose();
                }
                public void windowClosed(WindowEvent e) { log("WindowEvent: closed"); }
                public void windowIconified(WindowEvent e) { log("WindowEvent: iconified"); }
                public void windowDeiconified(WindowEvent e) { log("WindowEvent: deiconified"); }
                public void windowActivated(WindowEvent e) { log("WindowEvent: activated"); }
                public void windowDeactivated(WindowEvent e) { log("WindowEvent: deactivated"); }
            });
            wf.setVisible(true);
        });
        p.add(btn);
        return p;
    }

    // ─── ItemEvent ───
    private JPanel createItemEventPanel() {
        JPanel p = new JPanel(new GridLayout(2, 1, 5, 5));
        JCheckBox cb = new JCheckBox("Check me for ItemEvent");
        cb.addItemListener(e -> log("ItemEvent: stateChanged=" + e.getStateChange()));
        p.add(cb);

        JComboBox<String> combo = new JComboBox<>(new String[]{"A", "B", "C"});
        combo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                log("ItemEvent: Selected " + e.getItem());
        });
        p.add(combo);
        return p;
    }

    // ─── FocusEvent ───
    private JPanel createFocusEventPanel() {
        JPanel p = new JPanel(new GridLayout(2, 1, 5, 5));
        JTextField tf1 = new JTextField("Click here");
        JTextField tf2 = new JTextField("Then click here");

        FocusAdapter fa = new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                log("FocusEvent: gained on " + ((JTextField) e.getSource()).getText());
            }
            public void focusLost(FocusEvent e) {
                log("FocusEvent: lost on " + ((JTextField) e.getSource()).getText());
            }
        };
        tf1.addFocusListener(fa);
        tf2.addFocusListener(fa);

        p.add(tf1);
        p.add(tf2);
        return p;
    }

    // ─── MouseEvent with adapter ───
    private JPanel createMouseEventPanel() {
        JPanel p = new JPanel();
        JLabel mouseLabel = new JLabel("Click / move mouse on this label");
        mouseLabel.setOpaque(true);
        mouseLabel.setBackground(Color.YELLOW);
        mouseLabel.setPreferredSize(new Dimension(300, 100));
        mouseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mouseLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                log("MouseEvent: clicked at (" + e.getX() + "," + e.getY() + ")");
            }
            public void mouseEntered(MouseEvent e) { log("MouseEvent: entered"); }
            public void mouseExited(MouseEvent e) { log("MouseEvent: exited"); }
        });
        p.add(mouseLabel);
        return p;
    }

    // ─── KeyEvent ───
    private JPanel createKeyEventPanel() {
        JPanel p = new JPanel();
        JTextField keyField = new JTextField(20);
        keyField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                log("KeyEvent: pressed " + KeyEvent.getKeyText(e.getKeyCode()));
            }
            public void keyReleased(KeyEvent e) {
                log("KeyEvent: released " + KeyEvent.getKeyText(e.getKeyCode()));
            }
            public void keyTyped(KeyEvent e) {
                log("KeyEvent: typed '" + e.getKeyChar() + "'");
            }
        });
        p.add(new JLabel("Type in field:"));
        p.add(keyField);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab19_EventTypes::new);
    }
}
