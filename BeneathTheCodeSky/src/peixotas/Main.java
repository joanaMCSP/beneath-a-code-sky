package peixotas;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by jPeixoto on 24/03/16.
 */
public class Main extends Application {


    BorderPane root = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        primaryStage.setTitle("Beneath the Code Sky");
        Navigation.getInstance().loadScreen("splash");

    }
    public static void main(String[] args) {
        launch(args);
    }
}
