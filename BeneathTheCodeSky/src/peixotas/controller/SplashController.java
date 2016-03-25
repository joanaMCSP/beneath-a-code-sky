package peixotas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import peixotas.Navigation;
import peixotas.model.Game;
import peixotas.model.levels.Level;
import peixotas.model.levels.Level1;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mike on 24/03/16.
 */
public class SplashController implements Initializable, Controller {

    private Game game;
    private Scene scene;

    @FXML
    private Button start_button;

    @FXML
    void startButtonPressed(ActionEvent event) {

        // criar o level1 no model
        Level level = new Level1();

        // criar o level 1 no view
        Navigation.getInstance().loadScreen("level1");

        // settar o controller no level1
        LevelController level1Controller = (LevelController) Navigation.getInstance().getInitializable("level1");
        level.setController(level1Controller);
        level.run();

        // settar o level no controller
        level1Controller.setLevel(level);

        // settar o level1 no controller do level1
        level1Controller.loadLevel();

        // settar o player no controller do view1
        level1Controller.loadPlayer(game.getPlayer());



        //game.getPlayer();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
