import javax.swing.*;
import java.awt.*;

public class Image extends JFrame {

    public Image() {
        initUI();
    }

    private void initUI() {
        add(new Window());
        pack();
        setTitle("playerSprite");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Image ex = new Image();
                ex.setVisible(true);
            }
        });
    }
}
