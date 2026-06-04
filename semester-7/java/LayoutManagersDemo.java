import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LayoutManagersDemo {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Managers Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // 1. FlowLayout - components flow left to right, wrap to next line
        tabbedPane.addTab("FlowLayout", createFlowLayoutTab());
        
        // 2. BorderLayout - 5 regions: North, South, East, West, Center
        tabbedPane.addTab("BorderLayout", createBorderLayoutTab());
        
        // 3. GridLayout - uniform grid of rows and columns
        tabbedPane.addTab("GridLayout", createGridLayoutTab());
        
        // 4. BoxLayout - arranges components in single column or row
        tabbedPane.addTab("BoxLayout", createBoxLayoutTab());
        
        // 5. GridBagLayout - flexible grid with constraints
        tabbedPane.addTab("GridBagLayout", createGridBagLayoutTab());
        
        // 6. CardLayout - stacked cards, only one visible
        tabbedPane.addTab("CardLayout", createCardLayoutTab());
        
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    // 1. FlowLayout - simplest, components flow left to right
    private static JPanel createFlowLayoutTab() {
        JPanel panel = new JPanel(new java.awt.FlowLayout());
        
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Button 4"));
        panel.add(new JButton("Button 5"));
        panel.add(new JButton("Button 6"));
        panel.add(new JLabel("FlowLayout: Components flow left to right, wrap on next line"));
        
        return panel;
    }
    
    // 2. BorderLayout - 5 regions
    private static JPanel createBorderLayoutTab() {
        JPanel panel = new JPanel(new java.awt.BorderLayout(100, 10));
        
        panel.add(new JButton("NORTH"), java.awt.BorderLayout.NORTH);
        panel.add(new JButton("SOUTH"), java.awt.BorderLayout.SOUTH);
        panel.add(new JButton("EAST"), java.awt.BorderLayout.EAST);
        panel.add(new JButton("WEST"), java.awt.BorderLayout.WEST);
        panel.add(new JButton("CENTER"), java.awt.BorderLayout.CENTER);
        
        return panel;
    }
    
    // 3. GridLayout - uniform grid
    private static JPanel createGridLayoutTab() {
        JPanel panel = new JPanel(new java.awt.GridLayout(3, 3, 5, 5));
        
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Cell " + i));
        }
        
        return panel;
    }
    
    // 4. BoxLayout - vertical or horizontal stacking
    private static JPanel createBoxLayoutTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(new JButton("Button 1"));
        panel.add(Box.createVerticalStrut(10)); // Add space
        panel.add(new JButton("Button 2"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JButton("Button 3"));
        panel.add(Box.createVerticalGlue()); // Flexible space
        
        return panel;
    }
    
    // 5. GridBagLayout - flexible grid with constraints
    private static JPanel createGridBagLayoutTab() {
        JPanel panel = new JPanel(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        
        // Row 1: Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField(15), gbc);
        
        // Row 2: Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.fill = java.awt.GridBagConstraints.NONE;
        panel.add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField(15), gbc);
        
        // Row 3: Button spanning 2 columns
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        gbc.anchor = java.awt.GridBagConstraints.SOUTH;
        panel.add(new JButton("Submit"), gbc);
        
        return panel;
    }
    
    // 6. CardLayout - stacked cards, switch between them
    private static JPanel createCardLayoutTab() {
        final java.awt.CardLayout cardLayout = new java.awt.CardLayout();
        final JPanel cardPanel = new JPanel(cardLayout);
        
        // Create multiple cards
        JPanel card1 = new JPanel();
        card1.add(new JLabel("This is Card 1"));
        cardPanel.add(card1, "Card 1");
        
        JPanel card2 = new JPanel();
        card2.add(new JLabel("This is Card 2"));
        cardPanel.add(card2, "Card 2");
        
        JPanel card3 = new JPanel();
        card3.add(new JLabel("This is Card 3"));
        cardPanel.add(card3, "Card 3");
        
        // Navigation buttons
        JPanel navPanel = new JPanel();
        JButton prevBtn = new JButton("Previous");
        JButton nextBtn = new JButton("Next");
        
        prevBtn.addActionListener(e -> cardLayout.previous(cardPanel));
        nextBtn.addActionListener(e -> cardLayout.next(cardPanel));
        
        navPanel.add(prevBtn);
        navPanel.add(nextBtn);
        
        // Main panel
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.add(cardPanel, java.awt.BorderLayout.CENTER);
        mainPanel.add(navPanel, java.awt.BorderLayout.SOUTH);
        
        return mainPanel;
    }
}
