package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.Game;
import model.Level;
import model.Level1;


import java.net.URL;
import java.util.ResourceBundle;



/**
 * Created by Mike on 24/03/16.
 */
public class SplashController implements Initializable , Controller{

    private Scene scene;
    private Game game;


    @FXML
    private Button start_button;

    @FXML
    void startButtonPressed(ActionEvent event) {

        // get level1 from Game
        Level level = game.getLevels().get(0);
        // criar o level 1 no view
        level.init();

        Navigation.getInstance().loadScreen("level1");

        // settar o controller no level1
        Level1Controller level1Controller = (Level1Controller) Navigation.getInstance().getInitializable("level1");
        level.setController(level1Controller);

        // settar o level e o Game no controller
        level1Controller.setGame(game);
        level1Controller.setLevel((Level1)level);

        // settar o level1 no controller do level1
        level1Controller.loadLevel();

    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setGame(model.Game game) {
        this.game = game;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
