package org.bootcamp.hackathon.beneaththecodesky.model.levels;

import org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects.InteractableObject;
import org.bootcamp.hackathon.beneaththecodesky.terminal.Global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codecadet on 24/03/16.
 */
public abstract class Level {

    private List<Level> levelObjects;
    private Map<String, InteractableObject> interactableObjectMap;
    private String[] interactableObjects;
    private boolean complete;


    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public abstract void validate();

    public void initInteractableObjectMap() {

        //interactableObjectMap = Global.getInterctableObjectMap();
    }



}
