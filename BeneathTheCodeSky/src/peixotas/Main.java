package peixotas;

import javafx.application.Application;
import javafx.stage.Stage;
import peixotas.controller.SplashController;
import peixotas.model.Game;

/**
 * Created by jPeixoto on 24/03/16.
 */
public class Main extends Application {

    //BorderPane root = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        primaryStage.setTitle("Beneath the Code Sky");
        Navigation.getInstance().loadScreen("splash");

        Game game = new Game();

        SplashController splashController = (SplashController) Navigation.getInstance().getInitializable("splash");
        splashController.setGame(game);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
