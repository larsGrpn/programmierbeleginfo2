package org.programmierbeleg.programmierbeleg;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;
/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HelloController extends SceneController {

    @FXML
    private TextArea ergebnis;
    @FXML
    private TextField suchbegriff;
    @FXML
    private TextField eingabeAntwort;
    @FXML
    private TextField aufgabeAusgabe;
    @FXML
    private Rectangle richtig;
    @FXML
    private Rectangle falsch;

    private String loesung;


    @FXML

    public void onBaukastenClick(ActionEvent actionEvent) {

        switchTo("baukasten.fxml");
    }

    public void onTutorialClick(ActionEvent actionEvent) {
        switchTo("tutorial.fxml");
    }

    public void onSuchmaschineClick(ActionEvent actionEvent) {
        System.out.println("Button Gedrückt");

        switchTo("suchmaschine.fxml");
    }

    public void onCreditsClick(ActionEvent actionEvent) {
        switchTo("credits.fxml");
    }

    public void onBeendenClick(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onSuchenButtonClick(ActionEvent actionEvent) throws IOException {

        String relativeFilePath = "src/main/resources/aminosaeuren.json";  // Passen Sie diesen Pfad an
        Path path = Paths.get(relativeFilePath);
        ergebnis.setText("");
        try {
            if (Files.exists(path)) {
                InputStreamReader reader = new InputStreamReader(Files.newInputStream(path));
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Aminosaeuren>>() {
                }.getType();
                List<Aminosaeuren> aminosaeuren = gson.fromJson(reader, listType);
                System.out.println(aminosaeuren.size());
                System.out.println(aminosaeuren.get(0).toString());
                reader.close();

                // Zeigt die Elemente im TextArea an
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < aminosaeuren.size() - 1; i++) {
                    Aminosaeuren zwischenspeicher = aminosaeuren.get(i);
                    System.out.println("Name: " + zwischenspeicher.getName().toLowerCase());
                    System.out.println("Suchbegriff: " + suchbegriff.getText());
                    if (zwischenspeicher.getName().toLowerCase().equals(suchbegriff.getText().toLowerCase()) || zwischenspeicher.getAbkuerzung().toLowerCase().equals(suchbegriff.getText().toLowerCase()) || zwischenspeicher.getFormel().toLowerCase().equals(suchbegriff.getText().toLowerCase()) || zwischenspeicher.getMolmasse().toString().toLowerCase().equals(suchbegriff.getText().toLowerCase())) {
                        ergebnis.appendText(aminosaeuren.get(i).toString() + "\n");
                        System.out.println("Aminosäure gefunden: " + aminosaeuren.get(i).getName());
                        break;
                    }

                }
                if (ergebnis.getText().equals("")) {
                    ergebnis.setText("Aminosäure nicht gefunden");
                }
            } else {
                ergebnis.setText("File not found: " + path.toAbsolutePath().toString());
            }
        } catch (IOException e) {
            ergebnis.setText("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            ergebnis.setText("An error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onZurueckButtonClick(ActionEvent actionEvent) {

        switchTo("mainpage.fxml");

    }

    public void onbestaetigen(ActionEvent actionEvent) {
        richtig.setVisible(false);
        falsch.setVisible(false);
        if (loesung.toLowerCase().equals(eingabeAntwort.getText().toLowerCase())) {
            richtig.setVisible(true);
        } else {
            falsch.setVisible(true);
        }
    }

    public void ongenerieren(ActionEvent actionEvent) {

        richtig.setVisible(false);
        falsch.setVisible(false);
        eingabeAntwort.setText("");
        //aminsoaeurencodon[i][0] = aminosaeuren.get(i).getName();
        // aminsoaeurencodon[i][1] = aminosaeuren.get(i).getCodetriplett();
        String relativeFilePath = "src/main/resources/aminosaeuren.json";  // Passen Sie diesen Pfad an
        Path path = Paths.get(relativeFilePath);
        aufgabeAusgabe.setText("");
        try {
            if (Files.exists(path)) {
                InputStreamReader reader = new InputStreamReader(Files.newInputStream(path));
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Aminosaeuren>>() {
                }.getType();
                List<Aminosaeuren> aminosaeuren = gson.fromJson(reader, listType);
                System.out.println(aminosaeuren.size());
                System.out.println(aminosaeuren.get(0).toString());
                reader.close();

                // Zeigt die Elemente im TextArea an


                String[] aminosaure = new String[aminosaeuren.size()];
                int i;
                for (i = 0; i < aminosaeuren.size() - 1; i++) {
                    aminosaure[i] = aminosaeuren.get(i).getName();
                }
                Integer randomElement = (int) Math.floor(Math.random() * aminosaeuren.size());
                loesung = aminosaure[randomElement];
                System.out.println("Ausgabe: " + aminosaure[randomElement]);
                for (i = 0; i < aminosaeuren.size() - 1; i++) {
                    Aminosaeuren zwischenspeicher = aminosaeuren.get(i);
                    System.out.println("Name: " + zwischenspeicher.getName().toLowerCase());
                    if (aminosaeuren.get(i).getName().toLowerCase().equals(loesung.toLowerCase())) {
                        aufgabeAusgabe.setText(aminosaeuren.get(i).getCodetriplett() + "\n");
                        System.out.println("Aminosäure gefunden: " + aminosaeuren.get(i).getName());
                        break;
                    }
                }

            } else {
                aufgabeAusgabe.setText("File not found: " + path.toAbsolutePath().toString());
            }
        } catch (IOException e) {
            aufgabeAusgabe.setText("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            aufgabeAusgabe.setText("An error occured: " + e.getMessage());
            e.printStackTrace();
        }

    }
}