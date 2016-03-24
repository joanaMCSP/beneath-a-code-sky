package org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects;

/**
 * Created by codecadet on 24/03/16.
 */
public class Key extends InteractableObject {
    private boolean used;
    private boolean grabbed;


    public void drop() {

    }

    public boolean isUsed() {

        return used;
    }

    public void use() {

        if (!grabbed) {
            return;
        }
        used = true;
    }

    public void grab(){
        grabbed = true;

    }


}
