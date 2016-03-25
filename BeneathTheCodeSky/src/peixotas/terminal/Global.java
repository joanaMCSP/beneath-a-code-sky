package peixotas.terminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paulo Pereira on 24/03/16.
 */


public class Global {

    private static Map<String, String> map;

    public Global() {
        String path = "peixotas.model.interactable_objects.";
        map = new HashMap<>();
        map.put("box", path + "Box");
        map.put("door", path + "Door");
        map.put("key", path + "Key");
        map.put("tester", "peixotas.Tester");
    }

    public HashMap<String, String> getInteractableObjectMap(String[] objects) {

        HashMap<String, String> result = new HashMap<>();

        for (String o : objects) {
            if (map.containsKey(o)) {
                result.put(o, map.get(o));
            }
        }
        return result;
    }

    public void compare(List<String[]> list){
        for (int i = 0; i < list.size(); i++) {

            String key = list.get(i)[0];
            if (map.containsKey(key)){
                System.out.println("yay!");
            }
        }
    }

    public void quemFazEstaClasseAfinal() {
        System.out.println("fazemos nós ou fazem vcs?");
    }
}
