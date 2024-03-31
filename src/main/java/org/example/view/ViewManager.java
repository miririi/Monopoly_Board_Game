package org.example.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.model.Collect200Button;
import org.example.model.FreeParkingButton;
import org.example.model.GoJailButton;
import org.example.model.JustVisitingButton;

public class ViewManager {
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 800, 600);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void createButton() {
        FreeParkingButton free_parking_button = new FreeParkingButton();
        JustVisitingButton just_visiting_button = new JustVisitingButton();
        Collect200Button collect_200_button = new Collect200Button();
        GoJailButton go_jail_button = new GoJailButton();



        mainPane.getChildren().add(free_parking_button);
        mainPane.getChildren().add(just_visiting_button);
        mainPane.getChildren().add(collect_200_button);
        mainPane.getChildren().add(go_jail_button);
        /* button.setLayoutX(600);
        collect_200_button.setLayoutY(500); */
        mainPane.setTopAnchor(just_visiting_button, 0.0);
        mainPane.setLeftAnchor(just_visiting_button, 0.0);
        mainPane.setBottomAnchor(collect_200_button, 0.0);
        mainPane.setLeftAnchor(collect_200_button, 0.0);
        mainPane.setTopAnchor(free_parking_button, 0.0);
        mainPane.setRightAnchor(free_parking_button, 0.0);
        mainPane.setBottomAnchor(go_jail_button, 0.0);
        mainPane.setRightAnchor(go_jail_button, 0.0);



    }

}
