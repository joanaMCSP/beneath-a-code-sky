package controllers;


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import model.InteractableObject;
import model.Level1;
import model.Player;
import model.SpriteAnimation;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;


/**
 * Created by joana on 4/3/16.
 */
public class Level1Controller implements Initializable, Controller {

    private Level1 level;
    private Scene scene;


    private HashMap<InteractableObject, ImageView> representationMap;

    final DoubleProperty velocity = new SimpleDoubleProperty();
    final LongProperty lastUpdateTime = new SimpleLongProperty();
    private ArrayList<ImageView> views = new ArrayList<ImageView>();
    private Animation playerAnim;
    private ImageView playerView;
    private AudioClip plonkSound;


    final AnimationTimer animation = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            if (lastUpdateTime.get() > 0) {
                final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1000000000.0;
                final double deltaX = elapsedSeconds * velocity.get();
                final double oldX = playerView.getTranslateX();
                final double newX = Math.max(0, Math.min(1200, oldX + deltaX));
                playerView.setTranslateX(newX);
            }
            lastUpdateTime.set(timestamp);
        }
    };


    @FXML
    private Pane pane;
    @FXML
    private TextArea console;
    @FXML
    private Button submit_button;


    public void initialize(URL location, ResourceBundle resources) {


    }

    /**
     * Processes input from the console and performs action on objects
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
     * Initial level setup.
     * Gets interactableObject instances and associates them with a view in representatioMap
     * Starts Keys Event Handler todo: this should be its own method
     *
     */
    public void loadLevel() {



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
                        velocity.set(100);
                        playerView.setScaleX(1);
                        animation.start();
                        playerAnim.play();
                        playSound();
                        break;
                    case LEFT:
                        velocity.set(-100);
                        playerView.setScaleX(-1);
                        animation.start();
                        playerAnim.play();
                        playSound();
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

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                velocity.set(0);
                playerAnim.stop();
            }
        })
        ;
        animation.start();


    }

    private void playSound() {
        if (plonkSound.isPlaying()) {
            return;
        }

        plonkSound.play();
    }

    public void loadPlayer(Player player) {
        float px = player.getX();
        float py = player.getY();

        String audioFile;

        try {
            audioFile = new File("src/main/resources/walk.m4a").toURI().toURL().toString();
            plonkSound = new AudioClip(audioFile);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        playerView = new ImageView(player.getFileName());
        System.out.println(playerView);
        playerView.setViewport(new Rectangle2D(player.OFFSET_X, player.OFFSET_Y, player.WIDTH, player.HEIGHT));
        playerView.setY(px);
        playerView.setY(py);

        pane.getChildren().add(playerView);

        playerAnim = new SpriteAnimation(
                playerView,
                Duration.millis(1000),
                player.COUNT, player.COLUMNS,
                player.OFFSET_X, player.OFFSET_Y,
                player.WIDTH, player.HEIGHT
        );
        playerAnim.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Moves representations according to invoked methods
     * @param collection
     */
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

    public void setLevel(Level1 level) {
        this.level = level;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
