package peixotas.model.levels;

import peixotas.ObjectList;
import peixotas.controller.LevelController;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.terminal.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by codecadet on 24/03/16.
 */


//public class Level1 extends Levelii {
public class Level1 implements Level {


    private float DOOR_X = 700;
    private float DOOR_Y = 400;
    private final String[] levelObjects = new String[]{"door", "key"};

    private LevelController controller;

    private Map<String, InteractableObject> interactableObjects;


    public Level1() {

        interactableObjects = new HashMap<>();

    }

    public void init() {


        try {
            createObjects();


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

    public Collection<InteractableObject> getInteractableObjects() {
        return interactableObjects.values();

    }


    @Override
    public void setController(LevelController levelController) {
        this.controller = levelController;
    }

    private void createObjects() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        HashMap<String, String> objects = ObjectList.getInstance().getInteractableObjectMap(levelObjects);

        Set<String> keys = objects.keySet();


        for (String s : keys) {

            Class fullClass = Class.forName(objects.get(s));
            Constructor constructor = fullClass.getConstructor(Float.TYPE, Float.TYPE);

            InteractableObject obj = (InteractableObject) constructor.newInstance(DOOR_X, DOOR_Y);


            obj.getClass().getDeclaredMethods();


            interactableObjects.put(s, obj);

        }

    }

    public void execute(String code) throws InvocationTargetException, IllegalAccessException {
        List<String[]> commands = Parser.parse(code);

        for (String[] command : commands) {

            String object = command[0];
            String method = command[1];

            if (objectExists(object)) {

                try {
                    Method instruction = interactableObjects.get(object).getClass().getDeclaredMethod(method);
                    instruction.invoke(object);
                } catch (NoSuchMethodException e) {
                    System.out.println("There is no method with this name");
                }

            }
        }

    }

    private boolean objectExists(String object) {

        return interactableObjects.containsKey(object);
    }





    public void run() {
        init();
    }

}
