import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by joana on 3/27/16.
 */
public class Navigation {

    private static Navigation instance = null;
    private final int MIN_WIDTH = 600;
    private final int MIN_HEIGHT = 400;
    private Parent root;
    private final String VIEW_PATH = "view";
    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Initializable> controllers = new HashMap<String, Initializable>();


    private Stage stage;


    private Navigation() {

    }

    public static synchronized Navigation getInstance() {

        if (instance == null) {
            instance = new Navigation();
        }
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void loadScreen(String view) {

        try {
            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            System.out.println(VIEW_PATH + "/" + view + ".fxml");
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));

            root = fxmlLoader.load();

            Controller controller = fxmlLoader.getController();
            //Store the controller
            controllers.put(view, controller);

            // Create a new scene and add it to the stack
            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            controller.setScene(scene);
            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);
            controller.loadLevel();

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }

    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();

        setScene(scenes.peek());

    }

    private void setScene(Scene scene) {

        stage.setScene(scene);
    }
}

