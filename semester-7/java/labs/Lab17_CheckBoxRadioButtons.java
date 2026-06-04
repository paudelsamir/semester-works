import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Lab17_CheckBoxRadioButtons extends JFrame {
    
    private JCheckBox checkBox;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private ButtonGroup buttonGroup;
    
    Lab17_CheckBoxRadioButtons() {
        setTitle("CheckBox and RadioButtons");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // CheckBox
        checkBox = new JCheckBox("Enable Extra Options");
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    optionA.setEnabled(true);
                    optionB.setEnabled(true);
                    optionC.setEnabled(true);
                    System.out.println("Radio buttons enabled");
                } else {
                    optionA.setEnabled(false);
                    optionB.setEnabled(false);
                    optionC.setEnabled(false);
                    buttonGroup.clearSelection();
                    System.out.println("Radio buttons disabled");
                }
            }
        });
        panel.add(checkBox);
        
        panel.add(new JLabel("  "));  // Spacer
        
        // RadioButtons
        optionA = new JRadioButton("Option A");
        optionA.setEnabled(false);
        optionA.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Option A selected");
                }
            }
        });
        panel.add(optionA);
        
        optionB = new JRadioButton("Option B");
        optionB.setEnabled(false);
        optionB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Option B selected");
                }
            }
        });
        panel.add(optionB);
        
        optionC = new JRadioButton("Option C");
        optionC.setEnabled(false);
        optionC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Option C selected");
                }
            }
        });
        panel.add(optionC);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(optionA);
        buttonGroup.add(optionB);
        buttonGroup.add(optionC);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab17_CheckBoxRadioButtons();
            }
        });
        
        System.out.println("=============================");
        System.out.println("Lab No.: 17");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
