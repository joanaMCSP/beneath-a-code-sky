package peixotas.model.levels;

import peixotas.controller.LevelController;
import peixotas.model.interactable_objects.InteractableObject;

import java.util.ArrayList;

/**
 * Created by Mike on 25/03/16.
 */
public interface Level {

    ArrayList<InteractableObject> getGameObjects();

    void init();

    void setController(LevelController levelController);

    void createObjects();

    void run();

}
