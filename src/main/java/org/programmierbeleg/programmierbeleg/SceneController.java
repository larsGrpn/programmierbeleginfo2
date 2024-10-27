package org.programmierbeleg.programmierbeleg;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class SceneController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchTo(String fxml) {
        System.out.println(fxml);
        for (Window window : Stage.getWindows()) {
            if (window instanceof Stage) {
                Stage stage = (Stage) window;
                if (stage.getTitle().equals("Aminosäuren Datenbank")) {
                    stage.close();
                    break;
                }
            }
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Aminosäuren Datenbank");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaximized(true);
            primaryStage.show();

            if (this.stage != null) {
                this.stage.close();
            }
            this.stage = primaryStage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
