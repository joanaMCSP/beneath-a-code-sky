package org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects;
import org.bootcamp.hackathon.beneaththecodesky.view.representations.Interactable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Door extends InteractableObject {

    private Interactable representation;
    private boolean open;

    public Door(Interactable representation) {
        this.representation = representation;
    }

    public void open() {
        open = true;
    }

    public boolean isOpen() {
        return open;
    }
}
