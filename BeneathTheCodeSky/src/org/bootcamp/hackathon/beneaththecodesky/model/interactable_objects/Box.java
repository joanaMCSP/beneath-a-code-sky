package org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects;

import org.bootcamp.hackathon.beneaththecodesky.view.representations.Interactable;
import org.bootcamp.hackathon.beneaththecodesky.view.representations.Movable;

/**
 * Created by codecadet on 24/03/16.
 */
public class Box extends InteractableObject {

    private Interactable representation;

    public Box(Interactable representation){
        this.representation = representation;
    }

    public void push() {
        //representation.push();
    }


    public void pull() {
        //representation.pull();
    }

}
