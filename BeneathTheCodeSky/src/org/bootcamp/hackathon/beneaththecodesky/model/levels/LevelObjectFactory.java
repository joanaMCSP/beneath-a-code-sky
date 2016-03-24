package org.bootcamp.hackathon.beneaththecodesky.model.levels;

import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.*;

/**
 * Created by codecadet on 24/03/16.
 */
public class LevelObjectFactory {


    public static LevelObject createNewLevelObject(LevelObjectType type){

        LevelObject levelObject = null;

        switch (type){
            case FLOOR:
                levelObject = new Floor();
                break;
            case KEY:
                levelObject = new Key();
                break;
            case DOOR:
                levelObject = new Door();
                break;
            case BOX:
                levelObject = new Box();
        }

        return levelObject;
    }
}
