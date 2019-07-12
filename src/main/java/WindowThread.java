import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class WindowThread extends JPanel implements Runnable {

    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 600;
    private final int DELAY = 50;

    private PlayerShip playerShip;
    private Thread animator;
    KeyboardInput keyboard = new KeyboardInput();

    public WindowThread() {
        initWindow();
    }

    private void initWindow() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);
        addKeyListener(keyboard);
        setFocusable(true);
        playerShip = new PlayerShip();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPlayer(g);
    }

    private void drawPlayer(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(playerShip.getImage(), playerShip.getX(), playerShip.getY(), this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
            playerShip.move();
            keyboard.poll();
            processInput();
            repaint();

            if (keyboard.keyDownOnce(KeyEvent.VK_ESCAPE)) {
                break;
            }

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    protected void processInput() {
        if (keyboard.keyDown(KeyEvent.VK_DOWN)) {
            playerShip.setDy(5);
        }
        if (!keyboard.keyDown(KeyEvent.VK_DOWN)) {
            playerShip.setDy(0);
        }

        if (keyboard.keyDown(KeyEvent.VK_UP)) {
            playerShip.setDy(-5);
        }

        if (keyboard.keyDown(KeyEvent.VK_LEFT)) {
            playerShip.setDx(-5);
        }
        if (!keyboard.keyDown(KeyEvent.VK_LEFT)) {
            playerShip.setDx(0);
        }

        if (keyboard.keyDown(KeyEvent.VK_RIGHT)) {
            playerShip.setDx(5);
        }

        if (playerShip.getX() < 0) {
            playerShip.setX(0);
        }
        if (playerShip.getX() >= (B_WIDTH - playerShip.getImageWidth())) {
            playerShip.setX(B_WIDTH - playerShip.getImageWidth());
        }

        if (playerShip.getY() < 0) {
            playerShip.setY(0);
        }
        if (playerShip.getY() >= (B_HEIGHT - playerShip.getImageHeight())) {
            playerShip.setY(B_HEIGHT - playerShip.getImageHeight());
        }
    }
}
