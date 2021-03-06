package controllers;


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
import model.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;


/**
 * Created by joana on 4/3/16.
 */
public class Level1Controller extends LevelController implements Initializable, Controller {

    private Level1 level;
    private Scene scene;
    private Game game;
    private HashMap<InteractableObject, ImageView> representationMap;
    private ArrayList<ImageView> views = new ArrayList<ImageView>();


    @FXML
    private Pane pane;
    @FXML
    private TextArea console;
    @FXML
    private Button submit_button;

    @FXML
    private Button exitButton;


    public void initialize(URL location, ResourceBundle resources) {


    }

    public void setLevel(Level1 level) {
        this.level = level;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Processes input from the console and performs action on objects
     *
     * @param event
     */
    @FXML
    void onSubmitButtonClicked(ActionEvent event) {

        if(submit_button.getText().equals("Clear")){
            console.clear();
            submit_button.setText("Submit");
            return;
        }
        StringWriter stackTraceWriter = new StringWriter();
        try {
            level.execute(console.getText());
        } catch (InvocationTargetException e) {
            printStackTrace(stackTraceWriter, e);
            return;
        } catch (IllegalAccessException e) {
            printStackTrace(stackTraceWriter, e);
            return;
        } catch (NoSuchMethodException e) {
            printStackTrace(stackTraceWriter, e);
            return;
        }
        //move image correspondingly

        moveInteractableObject(level.getInteractableObjects());
        console.clear();

    }

    private void printStackTrace(StringWriter stackTraceWriter, Exception e) {
        e.printStackTrace(new PrintWriter(stackTraceWriter));
        console.appendText("\n" + stackTraceWriter.toString());
        submit_button.setText("Clear");
    }

    /**
     * Initial level setup.
     * Gets interactableObject instances and associates them with a view in representatioMap
     * Starts Keys Event Handler todo: this should be its own method
     */
    public void loadLevel() {


        exitButton.setVisible(false);

        game.getPlayer().load();
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
            view.setVisible(true);
        }
        //load level door
        for (InteractableObject object : representationMap.keySet()) {
            if (object instanceof Door) {
                Door door = (Door) object;
                door.setDoorView(representationMap.get(door));
                door.load();
                ImageView imageView = new ImageView("interactables/opendoor.png");
                imageView.setX(door.getX());
                imageView.setY(door.getY());
                pane.getChildren().add(imageView);
            }
            if (object instanceof Box) {
                bringImageToFront(object);
            }
        }
        handleInput();
        game.getPlayer().getAnimationTimer().start();

    }

    private void bringImageToFront(InteractableObject object) {
        pane.getChildren().remove(representationMap.get(object));
        pane.getChildren().add(representationMap.get(object));
    }

    private void handleInput() {

        final Player player = game.getPlayer();
        pane.getChildren().add(game.getPlayer().getPlayerView());
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                switch (event.getCode()) {
                    case RIGHT:
                        player.setVelocity(100);
                        player.getPlayerView().setScaleX(1);
                        player.getAnimationTimer().start();
                        player.getPlayerAnimation().play();
                        player.playSound();
                        break;
                    case LEFT:
                        player.setVelocity(-100);
                        player.getPlayerView().setScaleX(-1);
                        player.getAnimationTimer().start();
                        player.getPlayerAnimation().play();
                        player.playSound();
                        break;
                    case ENTER:
                        console.setPrefHeight(200);
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
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                player.setVelocity(0);
                player.getPlayerAnimation().stop();
            }
        })
        ;
    }

    /**
     * Moves representations according to invoked methods
     *
     * @param collection
     */
    private void moveInteractableObject(Collection<InteractableObject> collection) {
        for (InteractableObject object : collection) {
            if (object instanceof Door && ((Door) object).isOpen()) {
                exitButton.setVisible(true);
            }
            if (representationMap.containsKey(object)) {
                representationMap.get(object).setX(object.getX());
                representationMap.get(object).setY(object.getY());
                continue;
            }

        }

    }

    @FXML
    void onExitButtonClicked(ActionEvent event) {
        // get level1 from Game
        //Level level = game.getLevels().get(1);
        // criar o level 1 no view
        //level.init();

        Navigation.getInstance().loadScreen("nextLevel");

        // settar o controller no level1
        //Level1Controller level1Controller = (Level1Controller) Navigation.getInstance().getInitializable("level1");
        //level.setController(level1Controller);

        // settar o level e o Game no controller
        //level1Controller.setGame(game);
        //level1Controller.setLevel((Level1)level);


    }


}
