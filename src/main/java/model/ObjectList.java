package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Paulo Pereira on 24/03/16.
 */


public class ObjectList {

    private static ObjectList instance;

    private static Map<String, String> objectList;

    public static ObjectList getInstance() {

        if (instance == null) {
            instance = new ObjectList();
        }
        return instance;
    }

    private ObjectList() {
        objectList = new HashMap<String, String>();
        populateList();
    }

    private void populateList() {
        String path = "model.";
        objectList.put("box", path + "Box");
        objectList.put("key", path + "Key");
    }

    /**
     *
     *
     * @param  //set <String> representing objects to instanciate for level initialization
     * @return HashMap levelO <String, String> = <UserInputObject, ClassPathToThatObject >
     */
    public HashMap<String, String> getInteractableObjectMap(Set<String> levelObjects) {

        HashMap<String, String> result = new HashMap<String, String>();

        for (String o : levelObjects) {
            if (objectList.containsKey(o)) {
                result.put(o, objectList.get(o));
            }
        }
        return result;
    }

    public void compare(List<String[]> list) {
        for (int i = 0; i < list.size(); i++) {

            String key = list.get(i)[0];
            if (objectList.containsKey(key)) {
                System.out.println("yay!");
            }
        }
    }


}
