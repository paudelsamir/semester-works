import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Lab21_MenuBar extends JFrame implements ActionListener {

    private JLabel status;

    public Lab21_MenuBar() {
        setTitle("Lab 21 - Shishir Pandey (15/079, Sec A)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        status = new JLabel("Menu demo", SwingConstants.CENTER);
        status.setFont(status.getFont().deriveFont(14f));

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // ── File menu ──
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem newItem = new JMenuItem("New", createIcon(Color.BLUE));
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        newItem.addActionListener(this);
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Open", createIcon(Color.GREEN));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        // ── Edit menu (with submenu) ──
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(this);
        editMenu.add(cutItem);

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(this);
        editMenu.add(copyItem);

        // Submenu
        JMenu pasteSub = new JMenu("Paste");
        JMenuItem pastePlain = new JMenuItem("Paste as Plain Text");
        pastePlain.addActionListener(this);
        JMenuItem pasteRich = new JMenuItem("Paste as Rich Text");
        pasteRich.addActionListener(this);
        pasteSub.add(pastePlain);
        pasteSub.add(pasteRich);
        editMenu.add(pasteSub);

        editMenu.addSeparator();

        // Radio button menu items
        JRadioButtonMenuItem leftAlign = new JRadioButtonMenuItem("Left Align", true);
        JRadioButtonMenuItem centerAlign = new JRadioButtonMenuItem("Center Align");
        JRadioButtonMenuItem rightAlign = new JRadioButtonMenuItem("Right Align");
        ButtonGroup alignGroup = new ButtonGroup();
        alignGroup.add(leftAlign);
        alignGroup.add(centerAlign);
        alignGroup.add(rightAlign);

        leftAlign.addActionListener(this);
        centerAlign.addActionListener(this);
        rightAlign.addActionListener(this);

        editMenu.add(leftAlign);
        editMenu.add(centerAlign);
        editMenu.add(rightAlign);

        editMenu.addSeparator();

        // Checkable menu items
        JCheckBoxMenuItem spellCheck = new JCheckBoxMenuItem("Spell Check", true);
        spellCheck.addActionListener(this);
        JCheckBoxMenuItem wordWrap = new JCheckBoxMenuItem("Word Wrap", false);
        wordWrap.addActionListener(this);
        editMenu.add(spellCheck);
        editMenu.add(wordWrap);

        // Disabled menu item
        JMenuItem disabledItem = new JMenuItem("Disabled Option");
        disabledItem.setEnabled(false);
        editMenu.add(disabledItem);

        menuBar.add(editMenu);

        // ── Help menu ──
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
        add(status);
        setVisible(true);
    }

    private ImageIcon createIcon(Color c) {
        BufferedImage img = new BufferedImage(12, 12, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(c);
        g.fillRect(1, 1, 10, 10);
        g.dispose();
        return new ImageIcon(img);
    }

    public void actionPerformed(ActionEvent e) {
        status.setText("Selected: " + e.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab21_MenuBar::new);
    }
}
