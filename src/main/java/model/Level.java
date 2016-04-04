package model;

import controllers.Level1Controller;
import controllers.LevelController;
import terminal.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by joana on 4/4/16.
 */
public abstract class Level {

    private LevelController controller;
    private Map<String, int[]> interactableObjectNamePos;
    private Map<String, InteractableObject> interactableObjects;



    public Level(Map<String, int[]> interactableObjectNamePos) {
        this.interactableObjectNamePos = interactableObjectNamePos;
        interactableObjects = new HashMap<String, InteractableObject>();
    }



    public Map<String, int[]> getInteractableObjectNamePos() {
        return interactableObjectNamePos;
    }


    public void setController(Level1Controller controller) {
        this.controller = controller;
    }
    /**
     * Gets the interactableObject instances (values) from the HashMap
     * @return
     */
    public Collection<InteractableObject> getInteractableObjects() {
        return interactableObjects.values();
    }


    /**
     * Initializes Level1 and handles all Reflection exceptions
     */
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

    /**
     * Initialization of level objects through Reflection API
     * Gets initial interactables specifyed for this level and instantiates them
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private void createObjects()
            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        HashMap<String, String> objects = ClassMap.getInstance().getInteractableObjectMap(interactableObjectNamePos.keySet());

        Set<String> keys = objects.keySet();


        for (String s : keys) {

            Class fullClass = Class.forName(objects.get(s));
            Constructor constructor = fullClass.getConstructor(Float.TYPE, Float.TYPE);

            InteractableObject obj = (InteractableObject) constructor.newInstance(interactableObjectNamePos.get(s)[0],
                    interactableObjectNamePos.get(s)[1]);


            obj.getClass().getDeclaredMethods();

            interactableObjects.put(s, obj);
        }
    }

    /**
     * Calls parse() method to process user input and creates a String[] in which
     * the first position represents the Class and the second position represents
     * the method to be invoked
     * Checks if the instance of the class exists, if it does then proceeds to iterating
     * through the declared methods of the class until there's a match
     * If there is a match, the method is invoked;
     *
     * @param code String from userInput
     * @throws InvocationTargetException if user input does not match a declared method
     * @throws IllegalAccessException
     */
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


}

