package peixotas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import peixotas.model.interactable_objects.Door;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.model.levels.Level1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Mike on 24/03/16.
 */
public class Level1Controller implements Initializable {

    private Level1 level;
    private ArrayList<ImageView> views = new ArrayList<>();
    //private Door door;

    @FXML
    private Pane level_pane;

    @FXML
    private ImageView bgImage;

    @FXML
    private TextArea console;

    private ImageView doorView;


    @FXML
    void onConsoleClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLevel(Level1 level) {
        this.level = level;

        ArrayList<InteractableObject> gameObjects = level.getGameObjects();

        for (InteractableObject obj : gameObjects) {
            float x = obj.getX();
            float y = obj.getY();

            ImageView view = new ImageView(obj.getFileName());
            view.setX(x);
            view.setY(y);

            level_pane.getChildren().add(view);
            views.add(view);
        }


    }

}
