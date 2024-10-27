module org.programmierbeleg.programmierbeleg {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;
    requires java.desktop;
    opens org.programmierbeleg.programmierbeleg to com.google.gson, javafx.fxml;


    exports org.programmierbeleg.programmierbeleg;
}