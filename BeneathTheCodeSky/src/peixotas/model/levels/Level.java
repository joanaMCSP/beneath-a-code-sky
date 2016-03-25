package peixotas.model.levels;

import peixotas.controller.LevelController;
import peixotas.model.interactable_objects.InteractableObject;

import java.util.Collection;

/**
 * Created by Mike on 25/03/16.
 */
public interface Level {

    Collection<InteractableObject> getInteractableObjects();

    void init();

    void setController(LevelController levelController);

    void run();

}
