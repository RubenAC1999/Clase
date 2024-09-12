package controllers;

import database.GestorDB;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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

public class ControllerModificarPartido {

    GestorDB basedatos;
    private Partido partido;
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
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
        if (partido != null) {
            EtiquetaIDPartido.setText(partido.getId());
            LocalDate fecha = LocalDate.parse(partido.getFecha());
            EtiquetaFecha.setValue(fecha);
            EtiquetaHora.setText(partido.getHora());
            EtiquetaResultado.setText(partido.getResultado());
            EtiquetaTipo.setValue(partido.getTipo());
        }
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
        EtiquetaHora.clear();
        EtiquetaResultado.clear();
    }

    @FXML
    private void handleBtnConfirmar(ActionEvent event) {
        String ID = EtiquetaIDPartido.getText();
        LocalDate fecha = EtiquetaFecha.getValue();
        String hora = EtiquetaHora.getText();
        String resultado = EtiquetaResultado.getText();
        String tipo = EtiquetaTipo.getValue();

        if (hora == null || hora.trim().isEmpty()
                || resultado == null || resultado.trim().isEmpty()) {

            labelMensaje.setText("* Todos los campos son obligatorios.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!comprobarHora(hora)) {
            labelMensaje.setText("La hora debe estar en formato HH:mm.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!resultado.equalsIgnoreCase("Sin disputar") && !comprobarResultado(resultado)) {
            labelMensaje.setText("El resultado debe estar en formato X-Y o 'Sin disputar'.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            basedatos.modificarPartido(ID, fecha.toString(), hora, resultado, tipo);
            labelMensaje.setText("Partido modificado correctamente.");
            labelMensaje.setStyle("-fx-text-fill: white;");
        } catch (SQLException e) {
            labelMensaje.setText("Error al modificar el partido: " + e.getMessage());
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

}
