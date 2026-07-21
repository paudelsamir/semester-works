import javax.swing.*;
import java.awt.*;

public class Lab25_InternalFrames extends JFrame {

    public Lab25_InternalFrames() {
        setTitle("Lab 25 - Shishir Pandey (15/079, Sec A)");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JDesktopPane desktop = new JDesktopPane();

        // Create internal frames
        JInternalFrame frame1 = new JInternalFrame("Document 1", true, true, true, true);
        frame1.setSize(250, 180);
        frame1.setLocation(30, 30);
        frame1.add(new JLabel("This is internal frame 1", SwingConstants.CENTER));
        frame1.setVisible(true);
        desktop.add(frame1);

        JInternalFrame frame2 = new JInternalFrame("Document 2", true, true, true, true);
        frame2.setSize(250, 180);
        frame2.setLocation(130, 100);
        frame2.add(new JButton("Button inside internal frame"));
        frame2.setVisible(true);
        desktop.add(frame2);

        JInternalFrame frame3 = new JInternalFrame("Notes", true, true, true, true);
        frame3.setSize(250, 180);
        frame3.setLocation(230, 170);
        JTextArea ta = new JTextArea("Type here...");
        frame3.add(new JScrollPane(ta));
        frame3.setVisible(true);
        desktop.add(frame3);

        frame1.toFront();

        add(desktop, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab25_InternalFrames::new);
    }
}
