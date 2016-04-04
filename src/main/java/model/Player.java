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

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by joana on 4/3/16.
 * Only common object through all levels
 * Moves independently of terminal userInput(through keys)
 */
public class Player {

    public static final int COLUMNS = 8;
    public static final int COUNT = 8;
    public static final int OFFSET_X = 0;
    public static final int OFFSET_Y = 0;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 181;

    private float x;
    private float y;
    private String fileName;

    //Animation stuff
    final DoubleProperty velocity = new SimpleDoubleProperty();
    final LongProperty lastUpdateTime = new SimpleLongProperty();
    private Animation playerAnimation;
    private ImageView playerView;
    private AudioClip plonkSound;
    private final AnimationTimer animationTimer = new AnimationTimer() {
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


    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        fileName = "playerSprite.png";

    }

    public Animation getPlayerAnimation() {
        return playerAnimation;
    }

    public ImageView getPlayerView() {
        return playerView;
    }

    public AnimationTimer getAnimationTimer() {
        return animationTimer;
    }

    public void setVelocity(double velocity) {
        this.velocity.set(velocity);
    }

    public void load() {
        float px = x;
        float py = y;

        String audioFile;

        try {
            audioFile = new File("src/main/resources/walk.m4a").toURI().toURL().toString();
            plonkSound = new AudioClip(audioFile);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        playerView = new ImageView(fileName);
        playerView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        playerView.setY(px);
        playerView.setY(py);

        playerAnimation = new SpriteAnimation(
                playerView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        playerAnimation.setCycleCount(Animation.INDEFINITE);
    }

    public void playSound() {
        if (plonkSound.isPlaying()) {
            return;
        }
        plonkSound.play();
    }
}
