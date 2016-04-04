package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

    private final int MIN_WIDTH = 1280;
    private final int MIN_HEIGHT = 672;
    private final String VIEW_PATH = "/view/";

    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Initializable> controllers = new HashMap<String,Initializable>();

    private Stage stage;

    private Navigation() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static Navigation getInstance() {
        if (instance == null) {
            instance = new Navigation();
        }

        return instance;
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

        stage.show();
    }

    public void loadScreen(String view) {

        try {
            FXMLLoader fxmlLoader;

            String s = VIEW_PATH + view + ".fxml";
            System.out.println(s);
            fxmlLoader = new FXMLLoader(getClass().getResource(s));

            Parent root = fxmlLoader.load();

            Pane mainPane = new Pane();
            Initializable controller = fxmlLoader.getController();

            controllers.put(view, controller);


            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            ((Controller)controller).setScene(scene);
            scenes.push(scene);

            setScene(scene);

        } catch (IOException ioe) {
            System.out.println("Failure to load view " + view + ": " + ioe.getMessage());
        }

    }

    public Initializable getInitializable (String view) {
        return controllers.get(view);
    }

}
