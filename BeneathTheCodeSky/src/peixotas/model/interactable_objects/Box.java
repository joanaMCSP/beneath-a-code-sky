package peixotas.model.interactable_objects;

import peixotas.view.representations.Interactable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Box extends InteractableObject {

    public Box(float x, float y) {
        super(x, y, "gameobjects/box.png");
    }

    public void push() {
        System.out.println("this box is being very pushed");
        //representation.push();
    }


    public void pull() {
        //representation.pull();
    }

}
