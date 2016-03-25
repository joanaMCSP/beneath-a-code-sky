package peixotas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import peixotas.Navigation;
import peixotas.model.Game;
import peixotas.model.levels.Level1;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mike on 24/03/16.
 */
public class SplashController implements Initializable {

    private Game game;

    @FXML
    private Button start_button;

    @FXML
    void startButtonPressed(ActionEvent event) {

        // criar o level1 no model
        Level1 level1 = new Level1();

        // criar o level 1 no view
        Navigation.getInstance().loadScreen("level1");

        // settar o controller no level1
        Level1Controller level1Controller = (Level1Controller) Navigation.getInstance().getInitializable("level1");
        level1.setController(level1Controller);
        level1.run();

        // settar o level1 no controller do level1
        level1Controller.setLevel(level1);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setGame(Game game) {
        this.game = game;
    }
}
