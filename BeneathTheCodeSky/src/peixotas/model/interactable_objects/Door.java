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
        this.x = x;
        this.y = y;
    }

    public Door(Interactable representation) {
        this.representation = representation;
        float x = 100;
        float y = 100;
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
