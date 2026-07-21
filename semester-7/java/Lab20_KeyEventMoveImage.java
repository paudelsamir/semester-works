import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lab20_KeyEventMoveImage extends JFrame {

    private int rectX = 150, rectY = 150;
    private static final int STEP = 10;

    public Lab20_KeyEventMoveImage() {
        setTitle("Lab 20 - Shishir Pandey (15/079, Sec A)");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(rectX, rectY, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(rectX, rectY, 50, 50);
                g.drawString("Use Arrow Keys", 10, 20);
            }
        };
        canvas.setBackground(Color.WHITE);
        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:  rectX = Math.max(0, rectX - STEP); break;
                    case KeyEvent.VK_RIGHT: rectX = Math.min(canvas.getWidth() - 50, rectX + STEP); break;
                    case KeyEvent.VK_UP:    rectY = Math.max(0, rectY - STEP); break;
                    case KeyEvent.VK_DOWN:  rectY = Math.min(canvas.getHeight() - 50, rectY + STEP); break;
                }
                canvas.repaint();
            }
        });

        add(canvas);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab20_KeyEventMoveImage::new);
    }
}
