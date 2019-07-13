public class Explosion extends Sprite {

    public long timeInitialised;

    public Explosion(int x, int y) {
        super(x, y);
        initExplosion();
    }

    private void initExplosion() {
        loadImage("Resources/explosion3.png");
        getImageDimensions();
        timeInitialised = System.currentTimeMillis();
    }

    public boolean checkForRemoval() {
        long newTime, timeDiff, sleep;

        newTime = System.currentTimeMillis();
        timeDiff = newTime - timeInitialised;

        if (timeDiff > 200) {
            return true;
        } else {
            return false;
        }
    }
}
