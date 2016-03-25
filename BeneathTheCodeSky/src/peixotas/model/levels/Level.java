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
public abstract class Level {

    private Map<String, int[]> levelObjects;
    private LevelController controller;
    private Map<String, InteractableObject> interactableObjects;


    public Level(Map<String, int[]> levelObjects) {
        interactableObjects = new HashMap<>();
        this.levelObjects = levelObjects;
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

    public void setController(LevelController levelController) {
        this.controller = levelController;
    }

    private void createObjects() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        HashMap<String, String> objects = ObjectList.getInstance().getInteractableObjectMap(levelObjects.keySet());

        Set<String> keys = objects.keySet();


        for (String s : keys) {

            Class fullClass = Class.forName(objects.get(s));
            Constructor constructor = fullClass.getConstructor(Float.TYPE, Float.TYPE);

            InteractableObject obj = (InteractableObject) constructor.newInstance(levelObjects.get(s)[0], levelObjects.get(s)[1]);


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
                    instruction.invoke(interactableObjects.get(object));
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
