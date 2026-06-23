import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;

public class SwingBoilerplate {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing App");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ══════════════════════════════════════════
        //  LAYOUT
        // ══════════════════════════════════════════

        // Default: JPanel with FlowLayout
        JPanel panel = new JPanel();
        frame.add(panel);

        // Or pick another:
        // JPanel panel = new JPanel(new FlowLayout());
        // JPanel panel = new JPanel(new BorderLayout());
        // JPanel panel = new JPanel(new GridLayout(3, 2));
        // JPanel panel = new JPanel(new GridBagLayout());
        // panel.setLayout(null);          // absolute positioning

        // ══════════════════════════════════════════
        //  BASIC CONTROLS
        // ══════════════════════════════════════════

        // panel.add(new JLabel("Text:"));
        // panel.add(new JTextField(15));
        // panel.add(new JPasswordField(15));
        // panel.add(new JCheckBox("Check me", true));

        // Radio buttons (ButtonGroup groups them)
        // JRadioButton r1 = new JRadioButton("A", true);
        // JRadioButton r2 = new JRadioButton("B");
        // ButtonGroup bg = new ButtonGroup();
        // bg.add(r1); bg.add(r2);
        // panel.add(r1); panel.add(r2);

        // Combo box
        // panel.add(new JComboBox<>(new String[]{"Op1", "Op2", "Op3"}));

        // Slider
        // panel.add(new JSlider(0, 100, 50));

        // Text area + scroll pane
        // JTextArea ta = new JTextArea(5, 20);
        // panel.add(new JScrollPane(ta));

        // Borders
        // JPanel bp = new JPanel();
        // bp.setBorder(BorderFactory.createTitledBorder("Title"));
        // bp.add(new JLabel("Inside"));
        // panel.add(bp);

        // ══════════════════════════════════════════
        //  MENU
        // ══════════════════════════════════════════

        // JMenuBar mb = new JMenuBar();
        // JMenu file = new JMenu("File");  file.setMnemonic('F');
        // JMenuItem open = new JMenuItem("Open");
        // open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        // file.add(open);
        // file.add(new JCheckBoxMenuItem("Auto Save", true));
        // mb.add(file);
        // frame.setJMenuBar(mb);

        // Popup menu
        // JPopupMenu pop = new JPopupMenu();
        // pop.add(new JMenuItem("Pop Item"));
        // panel.setComponentPopupMenu(pop);

        // ══════════════════════════════════════════
        //  TOOLBAR  +  TOOLTIPS
        // ══════════════════════════════════════════

        // frame.setLayout(new BorderLayout());
        // JToolBar tb = new JToolBar();
        // JButton btn = new JButton("Save");
        // btn.setToolTipText("Click to save");
        // tb.add(btn);
        // frame.add(tb, BorderLayout.NORTH);
        // frame.add(panel, BorderLayout.CENTER);

        // ══════════════════════════════════════════
        //  DIALOGS
        // ══════════════════════════════════════════

        // JOptionPane.showMessageDialog(frame, "Hello");
        // String s = JOptionPane.showInputDialog(frame, "Name:");
        // int n = JOptionPane.showConfirmDialog(frame, "Continue?");
        // JFileChooser fc = new JFileChooser();  fc.showOpenDialog(frame);
        // Color c = JColorChooser.showDialog(frame, "Pick", Color.RED);

        // Custom dialog
        // JDialog d = new JDialog(frame, "Dialog", true);
        // d.setSize(200, 100);  d.setVisible(true);

        // ══════════════════════════════════════════
        //  INTERNAL FRAME
        // ══════════════════════════════════════════

        // JDesktopPane dp = new JDesktopPane();
        // frame.add(dp);
        // JInternalFrame ifr = new JInternalFrame("Child", true,true,true,true);
        // ifr.setSize(200,100);  ifr.setVisible(true);  dp.add(ifr);

        // ══════════════════════════════════════════
        //  TABLE
        // ══════════════════════════════════════════

        // JTable table = new JTable(
        //     new Object[][]{{1,"Alice"},{2,"Bob"}},
        //     new String[]{"ID","Name"}
        // );
        // panel.add(new JScrollPane(table));

        // Or with model:
        // DefaultTableModel model = new DefaultTableModel(
        //     new String[]{"Name","Score"}, 0
        // );
        // model.addRow(new Object[]{"Alice",90});
        // JTable t2 = new JTable(model);
        // panel.add(new JScrollPane(t2));

        // ══════════════════════════════════════════
        //  TREE
        // ══════════════════════════════════════════

        // DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        // root.add(new DefaultMutableTreeNode("Child 1"));
        // root.add(new DefaultMutableTreeNode("Child 2"));
        // JTree tree = new JTree(root);
        // panel.add(new JScrollPane(tree));

        // ══════════════════════════════════════════
        //  EVENT HANDLING
        // ══════════════════════════════════════════

        // JButton b = new JButton("Click");
        // b.addActionListener(e -> System.out.println("Clicked"));
        // b.addKeyListener(new KeyAdapter() { });
        // b.addMouseListener(new MouseAdapter() { });
        // panel.add(b);

        // ══════════════════════════════════════════

        frame.setVisible(true);
    }
}
