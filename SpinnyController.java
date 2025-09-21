import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class SpinnyController {
    @FXML
    private Button b1;
    @FXML
    private Button b2;

    @FXML
    private Pane pane;

    @FXML
    private void handleClick(ActionEvent e){
        pane.getChildren().clear();
        if(e.getSource() == b1) {
            Cube cube = new Cube(30);
            cube.setSpeed(.001);
            pane.getChildren().addAll(cube.getLinez());

            animate(cube);
        }
        else if(e.getSource() == b2){
            Pyramid pyramid = new Pyramid(50);
            pyramid.setSpeed(.001);
            pane.getChildren().addAll(pyramid.getLinez());
            animate(pyramid);
        }
    }

    private void animate(Cube a) {
        AnimationTimer timer = new AnimationTimer() {
            double dt = 1;
            double last = 0;

            public void handle(long now) {
                if (last < 0) {
                    last = now;
                    return;
                }
                dt = (now - last) / 1_000_000.0;
                last = now;

                a.run(dt);
                System.out.println(dt);

            }
        };
        timer.start();
    }
    private void animate(Pyramid a) {
        AnimationTimer timer = new AnimationTimer() {
            double dt = 1;
            double last = 0;

            public void handle(long now) {
                if (last < 0) {
                    last = now;
                    return;
                }
                dt = (now - last) / 1_000_000.0;
                last = now;

                a.run(dt);
            }
        };
        timer.start();
    }




}
