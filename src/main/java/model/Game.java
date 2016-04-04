package model;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import model.Player;

import java.io.File;
import java.net.MalformedURLException;
import java.util.LinkedList;


/**
 * Created by codecadet on 24/03/16.
 */
public class Game {

    private LinkedList<Level> levels;
    private Player player;

    public Game(){
        levels = new LinkedList<Level>();
        player = new Player(50, 400);
    }
    public LinkedList<Level> getLevels() {
        return levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public Player getPlayer() {
        return player;
    }

    public void run(Level level){
        levels.add(level);
    }




}
