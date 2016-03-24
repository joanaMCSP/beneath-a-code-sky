package org.bootcamp.hackathon.beneaththecodesky.model.levels;

import org.bootcamp.hackathon.beneaththecodesky.model.Level;
import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.LevelObjectType;

/**
 * Created by codecadet on 24/03/16.
 */
public class Level1 extends Level {


    public Level1(){

        LevelObjectFactory.createNewLevelObject(LevelObjectType.BOX);
    }
    @Override
    public void validate() {


    }
}
