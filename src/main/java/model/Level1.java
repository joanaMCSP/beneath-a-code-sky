package model;

import java.util.*;

/**
 * Created by joana on 4/3/16.
 */
public class Level1 extends Level {
    private static Map<String, int[]> levelObjects;
    /**
     * Indicates which objects should be instantiated for this level
     * and sets their initial position
     */
    static {
        levelObjects = new HashMap<String, int[]>();
        levelObjects.put("door", new int[]{700,400});
        levelObjects.put("box", new int[]{500,400});
        levelObjects.put("key", new int[]{900, 400});
    }

    public Level1() {
        super(Level1.levelObjects);
    }






}