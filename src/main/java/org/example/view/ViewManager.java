package org.example.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class ViewManager{

    protected Scene mainScene;
    protected Stage mainStage;

    public Stage getMainStage() {
        return mainStage;
    }

    public void setScene(AnchorPane pane){
        mainScene = new Scene(pane, 800, 800);
    }

    public void setStage(Stage stage){
        mainStage = stage;
        mainStage.setScene(mainScene);
    }
}
