package peixotas.model.levels;

import peixotas.controller.Level1Controller;
import peixotas.controller.LevelController;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.model.level_objects.LevelObject;
import sun.reflect.Reflection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by codecadet on 24/03/16.
 */
public abstract class Levelii {

    private Map<String, InteractableObject> interactableObjectMap;
    private boolean complete;
    private LevelController levelController;
    private ArrayList<InteractableObject> levelObjects;

    public void setController(Level1Controller controller) {
        this.levelController = levelController;
    }

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

    public void createObjects() {

    }


}
