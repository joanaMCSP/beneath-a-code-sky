package peixotas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import peixotas.Navigation;
import peixotas.model.Game;

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
        Navigation.getInstance().loadScreen("level1");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setGame(Game game) {
        this.game = game;
    }
}
