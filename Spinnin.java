
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Spinnin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        try {

            Pane root = new Pane();

            Scene s = new Scene(root, 400, 400);
            stage.setScene(s);
            stage.show();

            Spin cube = new Spin();
            root.getChildren().addAll(cube.getLinez());
            AnimationTimer timer = new AnimationTimer() {
                int t = 0;
                double dt = 1;
                double last = 0;

                public void handle(long now) {
                    if (last < 0) {
                        last = now;
                        return;
                    }
                    dt = (now - last) / 1_000_000.0;
                    last = now;
                    cube.run(dt);


                }
            };
            timer.start();
        }catch(Exception e){
            System.out.println("......    ");
            e.printStackTrace();
        }
    }


}