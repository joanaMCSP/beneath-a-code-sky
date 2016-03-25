package peixotas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import peixotas.model.interactable_objects.Door;
import peixotas.model.levels.Level1;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mike on 24/03/16.
 */
public class Level1Controller implements Initializable {

    private Level1 level;
    private Door door;

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
        //getDoorFromModel();
        //door = level.createDoor();
    }

    public void setLevel(Level1 level) {
        this.level = level;
        System.out.println("level: " + level);
        door = level.createDoor();
        System.out.println(level.getDoor());

        float x = door.getX();
        float y = door.getY();


        // move this from here asap
        doorView = new ImageView("gameobjects/door.png");
        doorView.setX(x);
        doorView.setY(y);

        level_pane.getChildren().add(doorView);

    }

}
