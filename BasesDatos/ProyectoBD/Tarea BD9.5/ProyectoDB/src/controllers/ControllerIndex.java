package controllers;

import database.GestorDB;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerIndex {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label campoEquipos;
    @FXML
    private Label campoJugadores;
    @FXML
    private Label campoPartidos;

    public void initialize() {
        anchorPane.setStyle("-fx-background-image: url('/img/fondoIndex.png');");
    }

    @FXML
    private void handleCampoEquipos(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) campoEquipos.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/equipos.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();

        }

    }

    @FXML
    private void handleCampoJugadores(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) campoJugadores.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/jugadores.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();

        }

    }

    @FXML
    private void handleCampoPartidos(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) campoPartidos.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/partidos.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();

        }

    }
}
