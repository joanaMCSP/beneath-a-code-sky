package peixotas.controller;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import peixotas.model.Player;
import peixotas.model.interactable_objects.InteractableObject;
import peixotas.model.levels.Level;
import peixotas.model.levels.Level1;

import java.util.ArrayList;

/**
 * Created by Mike on 25/03/16.
 */
public abstract class LevelController {

    //private Level level;
    private Pane pane;
    private Player player;
    private ImageView playerView;
    private ArrayList<ImageView> views = new ArrayList<>();


    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void loadLevel(Level level) {

        ArrayList<InteractableObject> gameObjects = level.getGameObjects();

        for (InteractableObject obj : gameObjects) {
            System.out.println(obj);
            float x = obj.getX();
            float y = obj.getY();

            System.out.println(x + "," + y);

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

        playerView.setY(px);
        playerView.setY(py);

        pane.getChildren().add(playerView);
    }
}
