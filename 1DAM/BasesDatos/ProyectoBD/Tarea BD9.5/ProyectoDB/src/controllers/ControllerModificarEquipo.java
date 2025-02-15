package controllers;

import database.GestorDB;
import java.io.IOException;

import java.sql.SQLException;

import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import objetos.Equipo;

public class ControllerModificarEquipo {

    GestorDB basedatos;
    private Equipo equipo;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button botonVolver;
    @FXML
    private Button botonConfirmar;
    @FXML
    private Button botonLimpiar;
    @FXML
    private TextField EtiquetaNombreEquipo;
    @FXML
    private TextField EtiquetaEstadio;
    @FXML
    private TextField EtiquetaDireccion;
    @FXML
    private TextField EtiquetaCapacidad;
    @FXML
    private TextField EtiquetaFechaFundacion;
    @FXML
    private ChoiceBox<String> EtiquetaNombreGrupo;
    @FXML
    private Label labelMensaje;

    public void initialize() {
        anchorPane.setStyle("-fx-background-image: url('/img/fondoIndex.png');");
        EtiquetaNombreGrupo.getItems().addAll("Grupo A", "Grupo B");
        basedatos = new GestorDB();

    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
        if (equipo != null) {
            EtiquetaNombreEquipo.setText(equipo.getNombre());
            EtiquetaEstadio.setText(equipo.getEstadio());
            EtiquetaDireccion.setText(equipo.getDireccion());
            EtiquetaCapacidad.setText(String.valueOf(equipo.getCapacidad()));
            EtiquetaNombreGrupo.setValue(equipo.getNombreGrupo());
            EtiquetaFechaFundacion.setText(String.valueOf(equipo.getFechaFundacion()));
        }
    }

    @FXML
    private void HandleBtnVolver(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) botonVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/equipos.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void handleBtnLimpiar(ActionEvent event) throws SQLException, IOException {
        EtiquetaNombreEquipo.clear();
        EtiquetaEstadio.clear();
        EtiquetaDireccion.clear();
        EtiquetaCapacidad.clear();
    }

    /* Comprueba si la capacidad es un número */
    private boolean comprobarCapacidad(String capacidad) {
        Pattern patron = Pattern.compile("\\d+");
        return patron.matcher(capacidad).matches();
    }

    @FXML
    private void handleBtnConfirmar(ActionEvent event) {
        String nombreEquipo = EtiquetaNombreEquipo.getText();
        String estadio = EtiquetaEstadio.getText();
        String direccion = EtiquetaDireccion.getText();
        String capacidad = EtiquetaCapacidad.getText();
        String fechaFundacion = EtiquetaFechaFundacion.getText();
        String nombreGrupo = EtiquetaNombreGrupo.getValue();
        String nombreAnterior = equipo.getNombre();

        if (nombreEquipo == null || nombreEquipo.trim().isEmpty()
                || estadio == null || estadio.trim().isEmpty()
                || direccion == null || direccion.trim().isEmpty()
                || capacidad == null || capacidad.trim().isEmpty()
                || fechaFundacion == null
                || nombreGrupo == null || nombreGrupo.trim().isEmpty()) {

            labelMensaje.setText("* Todos los campos son obligatorios.");
            labelMensaje.setStyle("-fx-text-fill: red;");
        } else {
            try {
                basedatos.modificarEquipo(nombreEquipo, estadio, direccion,
                        capacidad, fechaFundacion, nombreGrupo, nombreAnterior);
                labelMensaje.setText("Equipo modificado correctamente.");
                labelMensaje.setStyle("-fx-text-fill: white;");
            } catch (NumberFormatException e) {
                labelMensaje.setText("La capacidad y el año de fundación deben ser números.");
                labelMensaje.setStyle("-fx-text-fill: red;");
            } catch (SQLException e) {
                if (e.getErrorCode() == 1062) {
                    labelMensaje.setText("El equipo ya existe en la base de datos.");
                    labelMensaje.setStyle("-fx-text-fill: red;");
                }
            }
        }
    }
}
