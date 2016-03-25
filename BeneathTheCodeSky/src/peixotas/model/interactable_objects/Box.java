package peixotas.model.interactable_objects;

import peixotas.view.representations.Interactable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Box extends InteractableObject {

    private Interactable representation;

    public Box(float x, float y, String fileName, Interactable representation) {
        super(x, y, fileName);
        this.representation = representation;
    }

    public void push() {
        //representation.push();
    }


    public void pull() {
        //representation.pull();
    }

}
