package peixotas.controller;

import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import peixotas.model.Game;
import peixotas.model.Player;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.model.levels.Level;

import javafx.geometry.Rectangle2D;
import peixotas.view.SpriteAnimation;

import java.util.ArrayList;

/**
 * Created by Mike on 25/03/16.
 */
public abstract class LevelController implements Controller {

    //private Level level;
    private Pane pane;
    private Player player;
    private ImageView playerView;
    private Scene scene;
    //private Rectangle2D rectangle2D;
    //private Animation animation;
    private ArrayList<ImageView> views = new ArrayList<>();

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void loadLevel(Level level) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("key pressed: " + event.getText());
                double dx = playerView.getX() + 100;
                playerView.setX(dx);
            }
        });

        ArrayList<InteractableObject> gameObjects = level.getGameObjects();

        for (InteractableObject obj : gameObjects) {
            float x = obj.getX();
            float y = obj.getY();

            ImageView view = new ImageView(obj.getFileName());
            view.setX(x);
            view.setY(y);

            pane.getChildren().add(view);
            views.add(view);
        }

    }

    public void loadPlayer(Player player) {
        this.player = player;

        float px = player.getX();
        float py = player.getY();

        playerView = new ImageView(player.getFileName());
        //rectangle2D = new Rectangle2D(px, py, Game.WIDTH, Game.HEIGHT);

        //playerView.setViewport(rectangle2D);

        /*animation = new SpriteAnimation(playerView,
                Duration.millis(1000),
                Game.COUNT, Game.COLUMNS,
                Game.OFFSET_X, Game.OFFSET_Y,
                Game.WIDTH, Game.HEIGHT);*/

        //animation.setCycleCount(Animation.INDEFINITE);

        //animation.play();

        playerView.setY(px);
        playerView.setY(py);

        pane.getChildren().add(playerView);

        //installEventHandler(playerView);
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

}
