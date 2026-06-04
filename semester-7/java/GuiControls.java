import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiControls {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard Mnemonics and Accelerators");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Label with mnemonic
        JLabel label = new JLabel("E_nter Text:");
        label.setDisplayedMnemonic(KeyEvent.VK_N);
        panel.add(label);
        
        // Text Area
        JTextArea textArea = new JTextArea(10, 30);
        panel.add(textArea);
        
        // Buttons with mnemonics
        JButton submitBtn = new JButton("S_ubmit");
        submitBtn.setMnemonic(KeyEvent.VK_U);
        submitBtn.addActionListener(e -> textArea.append("\n[Submitted]\n"));
        panel.add(submitBtn);
        
        JButton clearBtn = new JButton("C_lear");
        clearBtn.setMnemonic(KeyEvent.VK_L);
        clearBtn.addActionListener(e -> textArea.setText(""));
        panel.add(clearBtn);
        
        JButton exitBtn = new JButton("E_xit");
        exitBtn.setMnemonic(KeyEvent.VK_X);
        exitBtn.addActionListener(e -> System.exit(0));
        panel.add(exitBtn);
        
        frame.add(new JScrollPane(panel));
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
