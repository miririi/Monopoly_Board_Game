package org.example.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.view.ViewManager;


public class Javafx extends Application {

        @Override
        public void start(Stage stage) {
            ViewManager view = new ViewManager();
            /**String javaVersion = System.getProperty("java.version");
            String javafxVersion = System.getProperty("javafx.version");
            Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
            Scene scene = new Scene(view, 640, 480);
            stage.setScene(scene);**/
            stage = view.getMainStage();
            stage.show();

        }

        public static void main(String[] args) {
            launch();
        }


}
