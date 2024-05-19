package org.example.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.entity.MonopolyGame;
import org.example.service.GameService;
import org.example.network.GameServer;
import org.example.network.GameClient;


public class MainMenu extends ViewManager {


    public AnchorPane startPane;
    private GameService service;
    private MonopolyGame game;
    private GameServer server;
    public MainMenu(MonopolyGame game){
        super();
        startPane = new AnchorPane();
        service = new GameService();
        this.game = game;
        game.start();
        //game = new MonopolyGame();
        //server = new GameServer(game);

    }

    public void createLayout() {
        Label label = new Label("Welcome to Monopoly Boardgame!");
        Button start = new Button("Start Game");
        label.setMinSize(200, 200);
        start.setMinSize(100, 100);
        start.setLayoutX(200);
        start.setLayoutY(200);
        label.setFont(Font.font("Verdana",23));
        startPane.getChildren().add(label);
        startPane.getChildren().add(start);
        ObservableList<String>characters = FXCollections.<String>observableArrayList("Dog", "Horse");
        ListView<String>character_list = new ListView<>(characters);
        character_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        character_list.setEditable(true);
        character_list.setLayoutX(350);
        character_list.setLayoutY(300);
        character_list.setMinSize(50, 50);
        startPane.getChildren().add(character_list);
        Label label1 = new Label("Name:");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        hb.setLayoutX(350);
        hb.setLayoutY(200);
        Button login = new Button("Login");
        startPane.getChildren().add(hb);
        startPane.getChildren().add(login);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                service.start_game(new GameScene(), textField.getAccessibleText(), character_list.getAccessibleText());

            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.start_game();
                System.out.println("New Login");

            }
        });

    }

    public void login(){

    }
}
