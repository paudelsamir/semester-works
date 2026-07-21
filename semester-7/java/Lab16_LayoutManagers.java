import javax.swing.*;
import java.awt.*;

public class Lab16_LayoutManagers extends JFrame {

    public Lab16_LayoutManagers() {
        setTitle("Lab 16 - Shishir Pandey (15/079, Sec A)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("FlowLayout", createFlowLayout());
        tabs.addTab("BorderLayout", createBorderLayout());
        tabs.addTab("GridLayout", createGridLayout());
        tabs.addTab("GridBagLayout", createGridBagLayout());
        tabs.addTab("GroupLayout", createGroupLayout());

        add(tabs);
        setVisible(true);
    }

    private JPanel createFlowLayout() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        p.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        for (int i = 1; i <= 6; i++) {
            p.add(new JButton("Button " + i));
        }
        return p;
    }

    private JPanel createBorderLayout() {
        JPanel p = new JPanel(new BorderLayout(5, 5));
        p.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
        p.add(new JButton("NORTH"), BorderLayout.NORTH);
        p.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        p.add(new JButton("EAST"), BorderLayout.EAST);
        p.add(new JButton("WEST"), BorderLayout.WEST);
        p.add(new JButton("CENTER"), BorderLayout.CENTER);
        return p;
    }

    private JPanel createGridLayout() {
        JPanel p = new JPanel(new GridLayout(3, 3, 5, 5));
        p.setBorder(BorderFactory.createTitledBorder("GridLayout 3x3"));
        for (int i = 1; i <= 9; i++) {
            p.add(new JButton("Cell " + i));
        }
        return p;
    }

    private JPanel createGridBagLayout() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(BorderFactory.createTitledBorder("GridBagLayout"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        p.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        p.add(new JTextField(15), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        p.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        p.add(new JTextField(15), gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.weighty = 1.0; gbc.anchor = GridBagConstraints.SOUTH;
        p.add(new JButton("Submit"), gbc);

        return p;
    }

    private JPanel createGroupLayout() {
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createTitledBorder("GroupLayout"));

        GroupLayout layout = new GroupLayout(p);
        p.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel label1 = new JLabel("User:");
        JTextField field1 = new JTextField(15);
        JLabel label2 = new JLabel("Pass:");
        JTextField field2 = new JTextField(15);
        JButton btn = new JButton("Login");

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(label1)
                    .addComponent(label2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(field1)
                    .addComponent(field2)
                    .addComponent(btn))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(field1))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(field2))
                .addComponent(btn)
        );

        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab16_LayoutManagers::new);
    }
}
