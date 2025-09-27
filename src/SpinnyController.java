/*
 * Course: CSC 1020 - 131
 * Spinning 3D shapes
 * TestSuite
 * Name: Korvan Nameni
 * Last Updated: 9/27/25
 */

package src;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller
 */
public class SpinnyController {

    @FXML
    private Pane pane;

    private AnimationTimer timer;
    private final double toMilliseconds = 1_000_000;
    private double dt;
    private double last;


    @FXML
    private void handlePressed(ActionEvent e){

        pane.getChildren().clear();

        Button tmp = (Button)e.getSource();
        String name = tmp.getText();

        ShapeMaker s = new ShapeMaker(name);
        pane.getChildren().addAll(s.getLinez());
        animate(s);
    }

    private void animate(ShapeMaker a) {
        if(timer!=null){
            timer.stop();
        }
        timer = new AnimationTimer() {
            public void handle(long now) {
                if (last < 0) {
                    last = now;
                }

                dt = (now - last) / toMilliseconds;
                last = now;

                a.run(dt);

            }
        };
        timer.start();
    }
}
