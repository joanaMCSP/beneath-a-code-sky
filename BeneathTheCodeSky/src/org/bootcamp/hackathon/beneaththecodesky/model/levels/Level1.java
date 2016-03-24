package org.bootcamp.hackathon.beneaththecodesky.model.levels;

import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.LevelObjectFactory;
import org.bootcamp.hackathon.beneaththecodesky.model.level_objects.LevelObjectType;
import org.bootcamp.hackathon.beneaththecodesky.terminal.Global;

import java.util.HashMap;

/**
 * Created by codecadet on 24/03/16.
 */
public class Level1 extends Level {


    public Level1 (){

    }

    public void init(){

        String[] levelObjects = new String[]{"door","key"};
        HashMap<String, String> temp = Global.getInteractableObjectMap(levelObjects);
        //TODO: Antoninho Reflection!!!!!!!!




    }

    public void run(){
        init();


    }

}
