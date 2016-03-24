package org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects;

import org.bootcamp.hackathon.beneaththecodesky.view.representations.Movable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Key extends InteractableObject {
    private Movable representation;
    private boolean used;
    private boolean grabbed;

    public Key(Movable representation) {
        this.representation = representation;
    }

    public boolean isUsed() {

        return used;
    }

    public void drop() {

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
