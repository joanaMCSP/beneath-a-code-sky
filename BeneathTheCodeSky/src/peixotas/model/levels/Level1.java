package peixotas.model.levels;

import peixotas.controller.Level1Controller;
import peixotas.model.interactable_objects.Door;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.terminal.Global;
import peixotas.view.representations.Interactable;
import sun.reflect.Reflection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by codecadet on 24/03/16.
 */
public class Level1 extends Level {

    private Level1Controller controller;
    private Door door;
    private ArrayList<InteractableObject> gameObjects;

    public Level1 (){
        gameObjects = new ArrayList<>();
    }



    public void init(){

        createObjects();
        // necessary objects for this lvl, in string
        String[] levelObjects = new String[]{"door","key"};

        // ask Global for levelObject "door" and "key"
        //HashMap<String, String> temp = Global.getInteractableObjectMap(levelObjects);
        //TODO: Antoninho Reflection!!!!!!!!

        // new door at x:1m, y:0m
        //door = new Door(1, 0);


    }

    public ArrayList<InteractableObject> getGameObjects() {
        return gameObjects;
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


    public void createObjects() {

        Door door = new Door(700,400);
        gameObjects.add(door);
    }
}
