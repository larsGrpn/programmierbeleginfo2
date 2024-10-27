package org.programmierbeleg.programmierbeleg;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MainController extends SceneController{
    public void onBaukastenClick(ActionEvent actionEvent) {
        switchTo("baukasten.fxml");
    }

    public void onTutorialClick(ActionEvent actionEvent) {
        switchTo("tutorial.fxml");
    }

    public void onSuchmaschineClick(ActionEvent actionEvent) {
        switchTo("suchmaschine.fxml");
    }

    public void onCreditsClick(ActionEvent actionEvent) {
        switchTo("credits.fxml");
    }

    public void onBeendenClick(ActionEvent actionEvent) {
        Platform.exit();
    }
}
