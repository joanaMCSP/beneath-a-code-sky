package peixotas.model;

/**
 * Created by codecadet on 24/03/16.
 */
public class Player {

    private float x;
    private float y;
    private String fileName;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        fileName = "gameobjects/playerSprite.png";

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
