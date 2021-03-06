package game.controller;

import game.Main;
import game.model.generator.DataGenerator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameAppController {

    private Stage primaryStage;

    public GameAppController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initRootLayout() {
        try {
            this.primaryStage.setTitle("Turtle Game");
            // load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/game.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();

            // set initial data into controller
            GameOverviewController controller = loader.getController();
            controller.setAppController(this);
            controller.setData(DataGenerator.generateGameData());

            // add layout to a scene and show them all
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            // don't do this in common apps
            e.printStackTrace();
        }

    }
}
