package peixotas.controller;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import peixotas.model.Player;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.model.levels.Level;
import peixotas.view.SpriteAnimation;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mike on 25/03/16.
 */
public abstract class LevelController implements Controller {

    @FXML
    private Pane pane;

    @FXML
    private ImageView bgImage;

    @FXML
    private TextArea console;

    @FXML
    private Button submit_button;

    private Level level;
    private Animation playerAnim;
    private ImageView playerView;
    private Scene scene;
    //private Rectangle2D rectangle2D;
    //private Animation animation;
    private AudioClip plonkSound;

    final DoubleProperty velocity = new SimpleDoubleProperty();
    final LongProperty lastUpdateTime = new SimpleLongProperty();
    private ArrayList<ImageView> views = new ArrayList<>();
    final AnimationTimer animation = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            if (lastUpdateTime.get() > 0) {
                final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0;
                final double deltaX = elapsedSeconds * velocity.get();
                final double oldX = playerView.getTranslateX();
                final double newX = Math.max(0, Math.min(1200, oldX + deltaX));
                playerView.setTranslateX(newX);
            }
            lastUpdateTime.set(timestamp);
        }
    };

    public void setLevel(Level level) {
        this.level = level;
    }

    public void loadLevel() {

        Collection<InteractableObject> gameObjects = level.getInteractableObjects();

        for (InteractableObject obj : gameObjects) {
            float x = obj.getX();
            float y = obj.getY();

            ImageView view = new ImageView(obj.getFileName());
            view.setX(x);
            view.setY(y);

            pane.getChildren().add(view);
            views.add(view);
        }


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
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
                        console.setVisible(true);
                        console.setStyle("-fx-text-fill: green");
                        submit_button.setVisible(true);
                        break;
                    case ESCAPE:
                        console.setVisible(false);
                        submit_button.setVisible(false);
                        break;
                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                velocity.set(0);
                playerAnim.stop();
            }
        });
        animation.start();

    }

    public void loadPlayer(Player player) {
        float px = player.getX();
        float py = player.getY();

        String audioFile;

        try {
            audioFile = new File("assets/walk.m4a").toURI().toURL().toString();
            plonkSound = new AudioClip(audioFile);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        playerView = new ImageView(player.getFileName());
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

    @FXML
    void onSubmitButtonClicked(ActionEvent event) {
        try {
            level.execute(console.getText());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        System.out.println(console.getText());
    }

    public void movePlayer(int x) {
        playerView.setX(x);
        System.out.println(playerView.getX());
        //playerView.translateXProperty();
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }



    /*private void installEventHandler(final Node keyboardNode) {
        final EventHandler<KeyEvent> key = new EventHandler<KeyEvent>() {
            @Override
            public void handle(final KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT) {
                    setPressed(event.getEventType() == KeyEvent.KEY_PRESSED);

                    event.consume();
                }
            }
        };
    }*/

    private void playSound() {
        if (plonkSound.isPlaying()) {
            return;
        }

        plonkSound.play();
    }

}
