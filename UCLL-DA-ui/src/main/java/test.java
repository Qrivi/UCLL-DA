/**
 * Created by Jan on 5/10/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class test extends Application{

    @Override
    public void start(Stage primaryStage) {

        BorderPane main = new BorderPane();

        Scene scene = new Scene(main, 500, 400);

        primaryStage.setTitle("Borecast!");
        primaryStage.setResizable( false );
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
