package peixotas.model.interactable_objects;

import peixotas.view.representations.Movable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Key extends InteractableObject {
    private Movable representation;
    private boolean used;
    private boolean grabbed;

    public Key(float x, float y) {
        super(x, y, "gameobjects/key.png");
    }

    public boolean isUsed() {

        return used;
    }

    public void drop() {

        System.out.println("this key is being much droped. So wow.");

    }



    public void use() {

        if (!grabbed) {
            return;
        }
        used = true;
    }

    public void grab() {
        grabbed = true;

    }


}
