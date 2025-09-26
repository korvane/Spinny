import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import src.ShapeMaker;

public class SpinnyController {
    @FXML
    private Button b1;
    @FXML
    private Button b2;

    @FXML
    private Pane pane;

    private AnimationTimer timer;


    @FXML
    private void handlePressed(ActionEvent e){

        pane.getChildren().clear();

        Button tmp = (Button)e.getSource();
        String name  = tmp.getText();

        ShapeMaker s = new ShapeMaker(name);
        s.setSpeed(.001);
        pane.getChildren().addAll(s.getLinez());
        animate(s);
    }

    private void animate(ShapeMaker a) {
        if(timer!=null){
            timer.stop();
        }
        timer = new AnimationTimer() {
            double dt = 1;
            double last = 0;
            int in = 0;

            public void handle(long now) {
                if (last < 0) {
                    last = now;
                    return;
                }
                in++;
                if(in==60){
                    System.out.println("tick");
                    in=0;
                }

                dt = (now - last) / 1_000_000.0;
                last = now;

                a.run(dt);

            }
        };
        timer.start();
    }
}
