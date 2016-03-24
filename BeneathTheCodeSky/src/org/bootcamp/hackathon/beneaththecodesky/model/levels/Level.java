package org.bootcamp.hackathon.beneaththecodesky.model.levels;

import org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects.InteractableObject;
import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.LevelObject;
import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.LevelObjectFactory;
import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.LevelObjectType;
import org.bootcamp.hackathon.beneaththecodesky.terminal.Global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codecadet on 24/03/16.
 */
public abstract class Level {

    private List<LevelObject> levelObjects;
    private Map<String, InteractableObject> interactableObjectMap;
    private boolean complete;




    public boolean isComplete() {
        return complete;
    }


    public abstract void init();

    public void levelComplete(){
        complete = true;
    }

    public abstract void run();

    public Map<String, InteractableObject> getInteractableObjectMap() {
        return interactableObjectMap;
    }


}
