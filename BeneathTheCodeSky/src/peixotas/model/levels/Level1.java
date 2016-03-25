package peixotas.model.levels;

import peixotas.ObjectList;
import peixotas.controller.Level1Controller;
import peixotas.controller.LevelController;
import peixotas.model.interactable_objects.Door;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.view.representations.Interactable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by codecadet on 24/03/16.
 */
//public class Level1 extends Levelii {
public class Level1 implements Level {


    private float DOOR_X = 700;
    private float DOOR_Y = 400;

    private LevelController controller;
    private ArrayList<InteractableObject> gameObjects;

    public Level1 (){
        gameObjects = new ArrayList<>();
    }

    public void init(){

        String[] levelObjects = new String[]{"door","key"};
        HashMap<String,String> objects = ObjectList.getInstance().getInteractableObjectMap(levelObjects);


        try {
            createObjects(objects);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<InteractableObject> getGameObjects() {
        return gameObjects;
    }

    @Override
    public void setController(LevelController levelController) {
        this.controller = levelController;
    }

    public void createObjects(HashMap<String, String> objects) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Set<String> keys = objects.keySet();

        for (String s: keys) {

            Class fullClass = Class.forName(objects.get(s));
            Constructor constructor = fullClass.getConstructor(Float.TYPE,Float.TYPE);

            InteractableObject obj = (InteractableObject) constructor.newInstance(DOOR_X,DOOR_Y);

            gameObjects.add(obj);
            System.out.println(gameObjects);
        }

    }

    public void run(){
        init();
    }

}
