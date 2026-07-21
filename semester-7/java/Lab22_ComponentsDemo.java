import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Lab22_ComponentsDemo extends JFrame {

    private JLabel status;

    public Lab22_ComponentsDemo() {
        setTitle("Lab 22 - Shishir Pandey (15/079, Sec A)");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        status = new JLabel(" ", SwingConstants.CENTER);
        status.setOpaque(true);
        status.setBackground(new Color(230, 230, 255));

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Slider", createSliderPanel());
        tabs.addTab("List", createListPanel());
        tabs.addTab("Table", createTablePanel());
        tabs.addTab("ProgressBar", createProgressBarPanel());
        tabs.addTab("Tree", createTreePanel());

        add(tabs, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
        setVisible(true);
    }

    // ─── Slider (ChangeEvent) ───
    private JPanel createSliderPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JLabel valueLabel = new JLabel("Value: 50", SwingConstants.CENTER);

        slider.addChangeListener(e -> {
            valueLabel.setText("Value: " + slider.getValue());
            status.setText("Slider changed to " + slider.getValue());
        });

        p.add(slider, BorderLayout.CENTER);
        p.add(valueLabel, BorderLayout.SOUTH);
        return p;
    }

    // ─── List (ListSelectionEvent) ───
    private JPanel createListPanel() {
        JPanel p = new JPanel(new BorderLayout());
        String[] items = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        JList<String> list = new JList<>(items);
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String sel = list.getSelectedValue();
                status.setText("List selected: " + sel);
            }
        });
        p.add(new JScrollPane(list), BorderLayout.CENTER);
        return p;
    }

    // ─── Table ───
    private JPanel createTablePanel() {
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"ID", "Name", "Grade"};
        Object[][] data = {
            {1, "Alice", "A"},
            {2, "Bob", "B+"},
            {3, "Charlie", "A-"},
            {4, "Diana", "B"}
        };
        JTable table = new JTable(data, cols);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    // ─── ProgressBar ───
    private JPanel createProgressBarPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(65);
        bar.setStringPainted(true);
        bar.setString("Loading... 65%");

        JButton btn = new JButton("Simulate Progress");
        btn.addActionListener(e -> {
            new Thread(() -> {
                for (int i = 0; i <= 100; i++) {
                    final int val = i;
                    SwingUtilities.invokeLater(() -> {
                        bar.setValue(val);
                        bar.setString("Progress: " + val + "%");
                        status.setText("Progress: " + val + "%");
                    });
                    try { Thread.sleep(50); } catch (InterruptedException ex) {}
                }
            }).start();
        });

        p.add(bar, BorderLayout.NORTH);
        p.add(btn, BorderLayout.CENTER);
        return p;
    }

    // ─── Tree ───
    private JPanel createTreePanel() {
        JPanel p = new JPanel(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("Branch 1");
        branch1.add(new DefaultMutableTreeNode("Leaf 1.1"));
        branch1.add(new DefaultMutableTreeNode("Leaf 1.2"));
        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("Branch 2");
        branch2.add(new DefaultMutableTreeNode("Leaf 2.1"));
        root.add(branch1);
        root.add(branch2);
        JTree tree = new JTree(root);
        p.add(new JScrollPane(tree), BorderLayout.CENTER);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab22_ComponentsDemo::new);
    }
}
