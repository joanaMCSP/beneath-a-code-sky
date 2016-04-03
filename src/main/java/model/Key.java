package model;

/**
 * Created by joana on 4/3/16.
 */
public class Key extends InteractableObject {

    public Key(float x, float y) {
        super(x, y, "key.png");
    }

    public void drop() {
        System.out.println("key being dropped");
        setY(getY() + 200);
    }
}
