package peixotas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private ImageView bgImage;

    @FXML
    private TextField console;

    private ImageView doorView;


    @FXML
    void onConsoleClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        door = level.getDoor();
        float x = door.getX();
        float y = door.getY();
        doorView = new ImageView("gameobject/door.png");
        doorView.setX(x);
        doorView.setY(y);
    }

    public void setLevel(Level1 level) {
        this.level = level;
    }

    /*public void creatDoor() {
        door = new ImageView("gameobject/door.png");
        door.
    }*/




}
