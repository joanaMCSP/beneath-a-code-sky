package controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Box;
import model.InteractableObject;
import model.Level;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by joana on 4/3/16.
 */
public class Controller implements Initializable {

    private Level level;
    private Scene scene;


    private HashMap<InteractableObject, ImageView> representationMap;
    private ArrayList<ImageView> views = new ArrayList<ImageView>();


    @FXML
    private Pane pane;
    @FXML
    private TextArea console;
    @FXML
    private Button submit_button;


    public void initialize(URL location, ResourceBundle resources) {


    }


    /**
     * processes input from the console and performs action on objects
     * @param event
     */
    @FXML
    void onSubmitButtonClicked(ActionEvent event) {
        try {
            level.execute(console.getText());
            moveInteractableObject(level.getInteractableObjects());
            console.clear();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     */
    public void loadLevel() {

        level = new Level();
        representationMap = new HashMap<InteractableObject, ImageView>();


        Collection<InteractableObject> levelInteractableObjects = level.getInteractableObjects();

        for (InteractableObject obj : levelInteractableObjects) {
            float x = obj.getX();
            float y = obj.getY();

            ImageView view = new ImageView(obj.getFileName());

            view.setId(obj.getFileName());
            representationMap.put(obj, view);
            view.setX(x);
            view.setY(y);
            pane.getChildren().add(view);
            views.add(view);
            System.out.println(obj.getFileName());
            view.setVisible(true);
        }

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                switch (event.getCode()) {
                    case RIGHT:
                        /*velocity.set(100);
                        playerView.setScaleX(1);
                        animation.start();
                        playerAnim.play();
                        playSound();*/
                        break;
                    case LEFT:
                        /*velocity.set(-100);
                        playerView.setScaleX(-1);
                        animation.start();
                        playerAnim.play();
                        playSound();*/
                        break;
                    case ENTER:
                        //console.setPrefHeight(200);
                        console.setVisible(true);
                        console.setStyle("-fx-background-color: black; -fx-text-fill: green");
                        submit_button.setVisible(true);
                        break;
                    case ESCAPE:
                        console.setPrefHeight(0);
                        console.setVisible(false);
                        submit_button.setVisible(false);
                        break;
                }

            }
        });

        /*scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                velocity.set(0);
                playerAnim.stop();
            }
        })*/
        ;
        //animation.start();


    }

    private void moveInteractableObject(Collection<InteractableObject> collection) {
        for (InteractableObject object : collection) {
            if (representationMap.containsKey(object)) {
                representationMap.get(object).setX(object.getX());
                representationMap.get(object).setY(object.getY());
                continue;
            }

          /*  if (object instanceof Key && representationMap.containsKey(object)) {
                representationMap.get(object).setY(550);
                break;
            }

            if (object instanceof Door && representationMap.containsKey(object)) {
                representationMap.get(object.getFileName());
            }*/
        }

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
