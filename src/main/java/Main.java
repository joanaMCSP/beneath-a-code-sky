import controllers.Navigation;
import controllers.SplashController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Game;
import model.Level;
import model.Level1;

/**
 * Created by jPeixoto on 15/03/16.
 */
public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        primaryStage.setTitle("Beneath the CodeSky");
        primaryStage.show();
        Navigation.getInstance().loadScreen("splash");

        Game game = new Game();
        SplashController splashController = (SplashController) Navigation.getInstance().getInitializable("splash");
        splashController.setGame(game);
        Level level = new Level1();
        game.run(level);


    }
}
