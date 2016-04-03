import javafx.application.Application;
import javafx.stage.Stage;

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
        Navigation.getInstance().loadScreen("initial");




    }
}
