package peixotas.model.levels;

import peixotas.controller.Level1Controller;
import peixotas.controller.LevelController;
import peixotas.model.interactable_objects.Door;
import peixotas.model.interactable_objects.InteractableObject;

import java.util.ArrayList;

/**
 * Created by codecadet on 24/03/16.
 */
//public class Level1 extends Levelii {
public class Level1 implements Level {

    private LevelController controller;
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

    }

    public ArrayList<InteractableObject> getGameObjects() {
        return gameObjects;
    }

    @Override
    public void setController(LevelController levelController) {
        this.controller = levelController;
    }

    public void createObjects() {
        Door door = new Door(700,400);
        System.out.println("anto print: " + door.getX());

        gameObjects.add(door);
    }

    public void run(){
        init();
    }

}
