package peixotas.model.levels;

import peixotas.controller.Level1Controller;
import peixotas.model.interactable_objects.Door;
import peixotas.terminal.Global;
import sun.reflect.Reflection;

import java.util.HashMap;

/**
 * Created by codecadet on 24/03/16.
 */
public class Level1 extends Level {

    private Level1Controller controller;

    private Door door;

    public Level1 (){

    }



    public void init(){

        // necessary objects for this lvl, in string
        String[] levelObjects = new String[]{"door","key"};

        // ask Global for levelObject "door" and "key"
        //HashMap<String, String> temp = Global.getInteractableObjectMap(levelObjects);
        //TODO: Antoninho Reflection!!!!!!!!

        // new door at x:1m, y:0m
        //door = new Door(1, 0);


    }

    public Door getDoor() {
        return door;
    }

    public void run(){
        init();
    }

    @Override
    public void setController(Level1Controller controller) {
        this.controller = controller;
    }

    public Door createDoor() {
        door = new Door(700, 300);
        return door;
    }
}
