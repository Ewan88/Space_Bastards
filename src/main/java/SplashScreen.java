public class SplashScreen extends Sprite {

    public SplashScreen(int x, int y) {
        super(x, y);
        initSplashScreen();
    }

    private void initSplashScreen() {
        loadImage("Resources/spacebastards.gif");
    }

    @Override
    public int getImageWidth() {
        return 800;
    }

    @Override
    public int getImageHeight() {
        return 600;
    }

    @Override
    protected void getImageDimensions() {
        this.width = 800;
        this.height = 600;
    }
}
