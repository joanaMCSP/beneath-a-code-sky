package peixotas.model.levels;

import peixotas.model.interactable_objects.InteractableObject;

import java.util.*;

/**
 * Created by codecadet on 24/03/16.
 */


//public class Level1 extends Levelii {
public class Level1 extends Level {

    private static Map<String, int[]> levelObjects;

    static {
        levelObjects = new HashMap<>();
        levelObjects.put("door", new int[]{400,400});
        levelObjects.put("box", new int[]{400,400});
        levelObjects.put("key", new int[]{800, 200});


    }

    private Map<String, InteractableObject> interactableObjects;


    public Level1() {
        super(Level1.levelObjects);
    }

}
