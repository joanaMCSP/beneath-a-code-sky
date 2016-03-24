package peixotas.model.levels;

import peixotas.model.interactable_objects.InteractableObject;
import peixotas.model.level_objects.LevelObject;

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
