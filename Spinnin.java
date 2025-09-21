import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Spinnin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Spinny.fxml"));
            Parent root = loader.load();
            Scene s = new Scene(root, 400, 400);
            stage.setScene(s);
            stage.setTitle("Spinning Shapes");
            stage.show();


        }catch(Exception e){
            System.out.println("......    ");
            e.printStackTrace();
        }
    }


}