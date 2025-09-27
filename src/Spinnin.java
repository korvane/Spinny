/*
 * Course: CSC 1020 - 131
 * Spinning 3D shapes
 * TestSuite
 * Name: Korvan Nameni
 * Last Updated: 9/27/25
 */
package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class
 */
public class Spinnin extends Application {

    @Override
    public void start(Stage stage){
        final int width = 400;
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Spinny.fxml"));
            Parent root = loader.load();
            Scene s = new Scene(root, width, width);
            stage.setScene(s);
            stage.setTitle("Spinning Shapes");
            stage.show();





        } catch(NullPointerException e) {
            System.out.println("Invalid FXML location. " + e);
        } catch(IOException e) {
            System.out.println("IO exception. " + e);
        }
    }
}