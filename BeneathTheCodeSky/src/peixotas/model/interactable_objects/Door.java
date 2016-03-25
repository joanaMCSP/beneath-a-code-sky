package peixotas.model.interactable_objects;
import peixotas.view.representations.Interactable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Door extends InteractableObject {

    private Interactable representation;
    private boolean open;
    private float x;
    private float y;


    public Door(float x, float y) {
        super(x,y,"gameobjects/door.png");
    }

    public void open() {
        open = true;
    }

    public boolean isOpen() {
        return open;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
