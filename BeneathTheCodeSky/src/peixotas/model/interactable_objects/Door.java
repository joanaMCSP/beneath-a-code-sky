package peixotas.model.interactable_objects;
import peixotas.view.representations.Interactable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Door extends InteractableObject {

    private Interactable representation;
    private boolean open;

    public Door(float x, float y) {
        super(x,y,"gameobjects/door.png");
    }

    public void open() {

        System.out.println("the door is open. wide.");
        //open = true; THIS IS THE REAL COMMAND!!!!!
    }

    public boolean isOpen() {
        return open;
    }

}
