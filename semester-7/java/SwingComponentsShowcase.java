import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.JWindow;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class SwingComponentsShowcase {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Components Showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Tab 1: Text Components
        tabbedPane.addTab("Text Components", createTextComponentsTab());
        
        // Tab 2: Buttons & Selection
        tabbedPane.addTab("Buttons & Selection", createButtonsTab());
        
        // Tab 3: Lists & Combos
        tabbedPane.addTab("Lists & Combos", createListsTab());
        
        // Tab 4: Menus
        tabbedPane.addTab("Menus", createMenusTab());
        
        // Tab 5: Layout Containers
        tabbedPane.addTab("Layout Containers", createLayoutTab());
        
        // Tab 6: Dialogs
        tabbedPane.addTab("Dialogs", createDialogsTab());
        
        // Tab 7: Progress & Sliders
        tabbedPane.addTab("Progress & Sliders", createProgressTab());
        
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    // TEXT COMPONENTS TAB
    private static JComponent createTextComponentsTab() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JLabel
        panel.add(new JLabel("JLabel:"));
        panel.add(new JLabel("This is a label"));
        
        // JTextField
        panel.add(new JLabel("JTextField:"));
        JTextField textField = new JTextField("Enter text here");
        panel.add(textField);
        
        // JPasswordField
        panel.add(new JLabel("JPasswordField:"));
        JPasswordField passwordField = new JPasswordField("password");
        panel.add(passwordField);
        
        // JTextArea
        panel.add(new JLabel("JTextArea:"));
        JTextArea textArea = new JTextArea("Multi-line\ntext area\ncomponent", 3, 15);
        textArea.setLineWrap(true);
        panel.add(new JScrollPane(textArea));
        
        // JFormattedTextField
        panel.add(new JLabel("JFormattedTextField:"));
        JFormattedTextField formattedField = new JFormattedTextField("###-###-####");
        panel.add(formattedField);
        
        return new JScrollPane(panel);
    }
    
    // BUTTONS TAB
    private static JComponent createButtonsTab() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JButton
        panel.add(new JLabel("JButton:"));
        panel.add(new JButton("Click Me!"));
        
        // JCheckBox
        panel.add(new JLabel("JCheckBox:"));
        panel.add(new JCheckBox("I agree to terms", true));
        
        // JRadioButton
        panel.add(new JLabel("JRadioButton:"));
        JRadioButton radio = new JRadioButton("Select one option", true);
        panel.add(radio);
        
        // JToggleButton
        panel.add(new JLabel("JToggleButton:"));
        panel.add(new JToggleButton("Toggle Me"));
        
        // Multiple RadioButtons with ButtonGroup
        panel.add(new JLabel("ButtonGroup (Radio):"));
        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton r1 = new JRadioButton("Option A", true);
        JRadioButton r2 = new JRadioButton("Option B");
        group.add(r1);
        group.add(r2);
        radioPanel.add(r1);
        radioPanel.add(r2);
        panel.add(radioPanel);
        
        return new JScrollPane(panel);
    }
    
    // LISTS & COMBOS TAB
    private static JPanel createListsTab() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JComboBox
        JPanel comboPanel = new JPanel(new BorderLayout());
        comboPanel.add(new JLabel("JComboBox:"), BorderLayout.NORTH);
        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4"};
        comboPanel.add(new JComboBox<>(items), BorderLayout.CENTER);
        panel.add(comboPanel);
        
        // JList
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JLabel("JList:"), BorderLayout.NORTH);
        JList<String> list = new JList<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"});
        listPanel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(listPanel);
        
        // JSpinner
        JPanel spinnerPanel = new JPanel(new BorderLayout());
        spinnerPanel.add(new JLabel("JSpinner:"), BorderLayout.NORTH);
        spinnerPanel.add(new JSpinner(new SpinnerNumberModel(5, 0, 10, 1)), BorderLayout.CENTER);
        panel.add(spinnerPanel);
        
        // Tree (JTree uses TreeModel)
        JPanel treePanel = new JPanel(new BorderLayout());
        treePanel.add(new JLabel("JTree:"), BorderLayout.NORTH);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        root.add(child1);
        root.add(child2);
        treePanel.add(new JScrollPane(new JTree(root)), BorderLayout.CENTER);
        panel.add(treePanel);
        
        return panel;
    }
    
    // MENUS TAB
    private static JPanel createMenusTab() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create MenuBar for demo purposes
        JMenuBar menuBar = new JMenuBar();
        
        // JMenu
        JMenu fileMenu = new JMenu("File");
        
        // JMenuItem
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        
        // JSeparator
        fileMenu.addSeparator();
        
        // JCheckBoxMenuItem
        fileMenu.add(new JCheckBoxMenuItem("Show Toolbar", true));
        
        // JRadioButtonMenuItem
        fileMenu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem radio1 = new JRadioButtonMenuItem("Light Theme", true);
        JRadioButtonMenuItem radio2 = new JRadioButtonMenuItem("Dark Theme");
        group.add(radio1);
        group.add(radio2);
        fileMenu.add(radio1);
        fileMenu.add(radio2);
        
        menuBar.add(fileMenu);
        panel.add(menuBar, BorderLayout.NORTH);
        
        JLabel info = new JLabel("<html><b>Menu Components:</b><br>" +
                "JMenuBar: Contains menus<br>" +
                "JMenu: Dropdown menu (File)<br>" +
                "JMenuItem: Menu items<br>" +
                "JCheckBoxMenuItem: Checkbox in menu<br>" +
                "JRadioButtonMenuItem: Radio button in menu<br>" +
                "JSeparator: Divider line</html>");
        panel.add(info, BorderLayout.CENTER);
        
        return panel;
    }
    
    // LAYOUT CONTAINERS TAB
    private static JPanel createLayoutTab() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JScrollPane
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.add(new JLabel("JScrollPane:"), BorderLayout.NORTH);
        JTextArea largeText = new JTextArea("Scrollable\nContent\nWith\nMany\nLines");
        scrollPanel.add(new JScrollPane(largeText), BorderLayout.CENTER);
        mainPanel.add(scrollPanel);
        
        // JSplitPane
        JPanel splitPanel = new JPanel(new BorderLayout());
        splitPanel.add(new JLabel("JSplitPane:"), BorderLayout.NORTH);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JButton("Left"), new JButton("Right"));
        splitPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(splitPanel);
        
        // JLayeredPane with JComponent
        JPanel layeredPanel = new JPanel(new BorderLayout());
        layeredPanel.add(new JLabel("JLayeredPane:"), BorderLayout.NORTH);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(200, 100));
        JButton btn1 = new JButton("Layer 1");
        JButton btn2 = new JButton("Layer 2");
        btn1.setBounds(10, 10, 100, 30);
        btn2.setBounds(60, 30, 100, 30);
        layeredPane.add(btn1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(btn2, JLayeredPane.PALETTE_LAYER);
        layeredPanel.add(new JScrollPane(layeredPane), BorderLayout.CENTER);
        mainPanel.add(layeredPanel);
        
        // JPanel info
        JPanel panelInfo = new JPanel();
        panelInfo.add(new JLabel("JPanel: Basic container for organizing components"));
        mainPanel.add(panelInfo);
        
        return mainPanel;
    }
    
    // DIALOGS TAB
    private static JComponent createDialogsTab() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JOptionPane
        panel.add(new JLabel("JOptionPane:"));
        JButton optionBtn = new JButton("Show Option Dialog");
        optionBtn.addActionListener(e -> 
            JOptionPane.showMessageDialog(null, "This is a message dialog"));
        panel.add(optionBtn);
        
        // JFileChooser
        panel.add(new JLabel("JFileChooser:"));
        JButton fileBtn = new JButton("Open File Chooser");
        fileBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
        });
        panel.add(fileBtn);
        
        // JColorChooser
        panel.add(new JLabel("JColorChooser:"));
        JButton colorBtn = new JButton("Open Color Chooser");
        colorBtn.addActionListener(e -> 
            JColorChooser.showDialog(null, "Choose Color", Color.WHITE));
        panel.add(colorBtn);
        
        // JDialog
        panel.add(new JLabel("JDialog:"));
        JButton dialogBtn = new JButton("Open Custom Dialog");
        dialogBtn.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle("Custom JDialog");
            dialog.setSize(300, 200);
            dialog.add(new JLabel("This is a custom dialog"));
            dialog.setVisible(true);
        });
        panel.add(dialogBtn);
        
        // JWindow
        panel.add(new JLabel("JWindow:"));
        JButton windowBtn = new JButton("Open Window");
        windowBtn.addActionListener(e -> {
            JWindow window = new JWindow();
            window.setSize(200, 100);
            window.add(new JLabel("This is a JWindow (no title bar)"));
            window.setVisible(true);
        });
        panel.add(windowBtn);
        
        return new JScrollPane(panel);
    }
    
    // PROGRESS & SLIDERS TAB
    private static JComponent createProgressTab() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JProgressBar
        panel.add(new JLabel("JProgressBar:"));
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(65);
        progressBar.setStringPainted(true);
        panel.add(progressBar);
        
        // JSlider
        panel.add(new JLabel("JSlider:"));
        panel.add(new JSlider(0, 100, 50));
        
        // JToolBar
        panel.add(new JLabel("JToolBar:"));
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("New"));
        toolBar.add(new JButton("Save"));
        toolBar.addSeparator();
        toolBar.add(new JButton("Help"));
        panel.add(toolBar);
        
        // JScrollBar (component)
        panel.add(new JLabel("JScrollBar:"));
        panel.add(new JScrollBar(JScrollBar.HORIZONTAL, 50, 10, 0, 100));
        
        // JToolTip
        panel.add(new JLabel("JToolTip:"));
        JButton btnWithTooltip = new JButton("Hover over me");
        btnWithTooltip.setToolTipText("This is a JToolTip!");
        panel.add(btnWithTooltip);
        
        // JTable
        panel.add(new JLabel("JTable:"));
        String[][] data = {{"John", "25"}, {"Jane", "30"}, {"Bob", "35"}};
        String[] columns = {"Name", "Age"};
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table));
        
        return new JScrollPane(panel);
    }
}
