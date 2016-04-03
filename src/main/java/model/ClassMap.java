package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Uses Reflection API to map  user input Strings to Classes
 * and their methods
 */


public class ClassMap {

    private static ClassMap instance;

    private static Map<String, String> interactablesList;

    public static ClassMap getInstance() {

        if (instance == null) {
            instance = new ClassMap();
        }
        return instance;
    }

    private ClassMap() {
        interactablesList = new HashMap<String, String>();
        populateList();
    }

    /**
     * Define interactables for the Game
     * and maps them to the corresponding Class
     */
    private void populateList() {
        String path = "model.";
        interactablesList.put("box", path + "Box");
        interactablesList.put("key", path + "Key");
    }

    /**
     * Receives a set of String keys representing the objects for a particular Level
     * If the key exists in interactablesList, it is added to the Hashmap which
     * this method returns, along with the path to the corresponding Class
     * Each level calls this method to instantiate these objects
     * through Reflection API
     *
     * @param // String set representing objects to instanciate for level initialization
     * @return HashMap levelO <String, String> = <UserInputObject, ClassPathToThatObject >
     */
    public HashMap<String, String> getInteractableObjectMap(Set<String> interactables) {

        HashMap<String, String> result = new HashMap<String, String>();

        for (String o : interactables) {
            if (interactablesList.containsKey(o)) {
                result.put(o, interactablesList.get(o));
            }
        }
        return result;
    }


    //todo: is this method needed?
    public void compare(List<String[]> list) {
        for (int i = 0; i < list.size(); i++) {

            String key = list.get(i)[0];
            if (interactablesList.containsKey(key)) {
                System.out.println("yay!");
            }
        }
    }
}
