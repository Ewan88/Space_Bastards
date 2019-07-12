import javax.swing.*;
import java.awt.*;
import java.awt.Image;

public class Window extends JPanel {

    private Image playerImage;

    public Window() {
        initWindow();
    }

    private void initWindow() {
        loadImage();
        int w = playerImage.getWidth(this);
        int h = playerImage.getHeight(this);
        setPreferredSize(new Dimension(h, w));
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("Resources/player1.png");
        playerImage = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(playerImage, 0, 0, null);
    }
}
