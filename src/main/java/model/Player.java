package model;

/**
 * Created by joana on 4/3/16.
 * Only common object through all levels
 * Moves independently of terminal userInput(through keys)
 */
public class Player {

    public static final int COLUMNS = 8;
    public static final int COUNT = 8;
    public static final int OFFSET_X = 0;
    public static final int OFFSET_Y = 0;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 181;


    private float x;
    private float y;
    private String fileName;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        fileName = "playerSprite.png";

    }

    public String getFileName() {
        return fileName;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public void moveX() {

    }

    public void jump() {

    }
}
