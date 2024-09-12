package controllers;

import database.GestorDB;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import objetos.Partido;

public class ControllerAnhadirPartido {

    GestorDB basedatos;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button botonVolver;
    @FXML
    private Button botonConfirmar;
    @FXML
    private Button botonLimpiar;
    @FXML
    private DatePicker EtiquetaFecha;
    @FXML
    private TextField EtiquetaHora;
    @FXML
    private TextField EtiquetaResultado;
    @FXML
    private ChoiceBox<String> EtiquetaTipo;
    @FXML
    private TextField EtiquetaIDPartido;
    @FXML
    private Label labelMensaje;

    public void initialize() {
        basedatos = new GestorDB();
        anchorPane.setStyle("-fx-background-image: url('/img/fondoIndex.png');");
        EtiquetaTipo.getItems().addAll("Regular", "Playoff");
        EtiquetaIDPartido.setText(String.valueOf(generadorIDPartido()));
    }

    @FXML
    private void HandleBtnVolver(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) botonVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/partidos.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void handleBtnLimpiar(ActionEvent event) throws SQLException, IOException {
        EtiquetaFecha.setValue(null);
        EtiquetaHora.clear();
        EtiquetaResultado.clear();
        EtiquetaTipo.setValue(null);
        labelMensaje.setText("");
    }

    @FXML
    private void handleBtnConfirmar(ActionEvent event) {

        LocalDate fecha = EtiquetaFecha.getValue();
        String hora = EtiquetaHora.getText();
        String resultado = EtiquetaResultado.getText();
        String tipo = EtiquetaTipo.getValue();
        String id = EtiquetaIDPartido.getText();
        
        if (fecha == null || hora == null || hora.trim().isEmpty()
                || tipo == null || tipo.trim().isEmpty()) {

            labelMensaje.setText("* Todos los campos son obligatorios.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!comprobarHora(hora)) {
            labelMensaje.setText("La hora debe estar en formato HH:mm.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        if (resultado != null && !resultado.trim().isEmpty() && !resultado.equalsIgnoreCase("Sin disputar") && !comprobarResultado(resultado)) {
            labelMensaje.setText("El resultado debe estar en formato X-Y o 'Sin disputar'.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            Partido partidoCreado = new Partido(id, fecha.toString(), hora, resultado, tipo);
            basedatos.insertarNuevoPartido(partidoCreado);
            labelMensaje.setText("Partido añadido correctamente");
            labelMensaje.setStyle("-fx-text-fill: white;");
        } catch (SQLException e) {
            labelMensaje.setText("Error al añadir el partido: " + e.getMessage());
            labelMensaje.setStyle("-fx-text-fill: red;");
        }
    }

    private boolean comprobarHora(String hora) {
        Pattern patron = Pattern.compile("^(?:[01]\\d|2[0-3]):[0-5]\\d$");
        return patron.matcher(hora).matches();
    }

    private boolean comprobarResultado(String resultado) {
        Pattern patron = Pattern.compile("^\\d+-\\d+$");
        return patron.matcher(resultado).matches();
    }

    private int generadorIDPartido() {
        Random rand = new Random();
        int numeroGenerado = 0;
        do {
            numeroGenerado = rand.nextInt(90000) + 10000;

        } while (basedatos.existePartido(String.valueOf(numeroGenerado)));

        return numeroGenerado;
    }

}
