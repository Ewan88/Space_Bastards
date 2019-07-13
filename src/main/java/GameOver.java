public class GameOver extends Sprite {

    public GameOver(int x, int y) {
        super(x, y);
        initGameOver();
    }

    private void initGameOver() {
        loadImage("Resources/gameover2.gif");
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
