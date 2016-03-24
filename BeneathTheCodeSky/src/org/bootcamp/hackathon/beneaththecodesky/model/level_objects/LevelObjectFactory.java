package org.bootcamp.hackathon.beneaththecodesky.model.level_objects;

import org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects.Box;
import org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects.Door;
import org.bootcamp.hackathon.beneaththecodesky.model.interactable_objects.Key;
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
            case PLATFORM:
                levelObject = new Platform();
                break;

        }

        return levelObject;
    }
}
