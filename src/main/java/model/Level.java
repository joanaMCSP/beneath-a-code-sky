package model;

import controller.Controller;
import terminal.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by joana on 4/3/16.
 */
public class Level {

    private Controller controller;
    private Map<String, InteractableObject> interactableObjects;
    private Map<String, int[]> levelObjects;


    public Level() {
        interactableObjects = new HashMap<String, InteractableObject>();
        setLevelObjects();
        init();

    }

    public void setLevelObjects(){
        levelObjects = new HashMap<String, int[]>();
        levelObjects.put("box", new int[]{200, 300});
        levelObjects.put("key", new int[]{500, 100});
        //levelObjects.put("box", new int[]{200, 400})

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

    public void setController(Controller levelController) {
        this.controller = levelController;
    }

    /**
     * Initialization of initial level objects through reflection - THIS MAKES NO SENSE AT ALL
     *
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


    public void run() {
        init();
    }


}
