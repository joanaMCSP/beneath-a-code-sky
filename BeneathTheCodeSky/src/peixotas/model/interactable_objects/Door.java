package peixotas.model.interactable_objects;
import peixotas.view.representations.Interactable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Door extends InteractableObject {

    private boolean open;

    public Door(float x, float y) {
        super(x,y,"gameobjects/door.png");
    }

    public void open() {

        System.out.println("this door is very open. very wide.");
        open = true;
    }

    public boolean isOpen() {
        return open;
    }

}
