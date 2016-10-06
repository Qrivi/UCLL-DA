package sample; /**
 * Created by Jan on 5/10/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load( getClass().getClassLoader().getResource( "sample.fxml" ) );
        Scene scene = new Scene(root, 1200, 350);

        primaryStage.setTitle("Borecast!");
        primaryStage.setResizable( false );
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
