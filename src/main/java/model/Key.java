package model;

/**
 * Created by joana on 4/3/16.
 */
public class Key extends InteractableObject {

    private boolean use;

    public Key(float x, float y) {
        super(x, y, "interactables/key.png");
    }

    public void drop() {
        System.out.println("key being dropped");
        setY(getY() + 400);
    }
    public void get(){
        setX(getX()+3000);
        setY(getY()+3000);
    }

    public void use(){
        System.out.println("Key being used");
        use = true;
    }

    public boolean isUse() {
        return use;
    }
}
