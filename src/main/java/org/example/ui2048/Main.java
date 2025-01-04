package org.example.ui2048;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main extends Application {

    private Game game;
    @Override
    public void start(Stage stage) throws IOException {
        Controller controller = new Controller();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load());
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(keyEvent.getCode())
                {
                    case UP -> game.moveUp();
                    case RIGHT -> game.moveRight();
                    case DOWN -> game.moveDown();
                    case LEFT -> game.moveLeft();
                }


                controller.setScore(game.countScore());
                controller.setBoard(game.getCellsValue(), game.getCellsColor());

                if (!game.canUserMove()) {
                    game.gameOver();
                    // TODO okienko pytania o nową grę
                }
            }
        });
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();

        game = new Game(4, fxmlLoader.getController());
        game.createGame();
        Thread thread = new Thread(game);
        thread.start();
        //game.loop();
    }

    public static void main(String[] args) {
        launch();
    }
}