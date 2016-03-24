package org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects;

/**
 * Created by codecadet on 24/03/16.
 */
public class Door extends InteractableObjects {

    private boolean open;

    public void open() {
        open = true;
    }

    public boolean isOpen() {
        return open;
    }
}
