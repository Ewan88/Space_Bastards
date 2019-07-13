public class Missile extends Sprite {

    private final int BOARD_WIDTH = 590;
    private final int MISSILE_SPEED = 10;

    public Missile(int x, int y) {
        super(x, y);
        initMissile();
    }

    private void initMissile() {
        loadImage("Resources/projectile.png");
        getImageDimensions();
    }

    public void move() {
        x += MISSILE_SPEED;

        if (x > BOARD_WIDTH) {
            vis = false;
        }
    }

}