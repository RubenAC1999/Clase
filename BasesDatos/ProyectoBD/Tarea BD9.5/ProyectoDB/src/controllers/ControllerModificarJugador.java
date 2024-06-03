package controllers;

import database.GestorDB;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
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
import objetos.Jugador;

public class ControllerModificarJugador {

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
    private TextField EtiquetaIDJugador;
    @FXML
    private TextField EtiquetaNombre;
    @FXML
    private TextField EtiquetaApellidos;
    @FXML
    private DatePicker EtiquetaFechaNacimiento;
    @FXML
    private ChoiceBox<String> EtiquetaPosicion;
    @FXML
    private TextField EtiquetaDorsal;
    @FXML
    private ChoiceBox<String> EtiquetaNombreEquipo;
    @FXML
    private Label labelMensaje;
    private Jugador jugador;

    public void initialize() {
        basedatos = new GestorDB();
        anchorPane.setStyle("-fx-background-image: url('/img/fondoIndex.png');");
        EtiquetaPosicion.getItems().addAll("POR", "DEF", "MED", "DEL");
        EtiquetaIDJugador.setText(String.valueOf(generadorID()));
        EtiquetaIDJugador.setStyle("-fx-background-color: lightgrey;");
        cargarNombresEquipos();
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
        EtiquetaIDJugador.setText(jugador.getId());
        EtiquetaNombre.setText(jugador.getNombre());
        EtiquetaApellidos.setText(jugador.getApellidos());

        LocalDate fechaNacimiento = LocalDate.parse(jugador.getFechaNacimiento());
        EtiquetaFechaNacimiento.setValue(fechaNacimiento);

        EtiquetaPosicion.setValue(jugador.getPosicion());
        EtiquetaDorsal.setText(String.valueOf(jugador.getDorsal()));
        EtiquetaNombreEquipo.setValue(jugador.getNombreEquipo());
    }

    @FXML
    private void HandleBtnVolver(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) botonVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/jugadores.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void handleBtnLimpiar(ActionEvent event) throws SQLException, IOException {
        EtiquetaNombre.clear();
        EtiquetaApellidos.clear();
        EtiquetaDorsal.clear();
    }

    private boolean comprobarFecha(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears() >= 16;
    }

    private int generadorID() {
        Random rand = new Random();
        int numeroGenerado = 0;
        do {
            numeroGenerado = rand.nextInt(90000) + 10000;

        } while (basedatos.existeJugador(String.valueOf(numeroGenerado)));

        return numeroGenerado;
    }

    private boolean comprobarDorsal(int dorsal) {
        if (dorsal >= 1 && dorsal <= 99) {
            return true;
        }
        return false;
    }

    private void cargarNombresEquipos() {
        try {
            List<String> nombresEquipos = basedatos.obtenerNombresEquipos();
            EtiquetaNombreEquipo.getItems().addAll(nombresEquipos);
        } catch (SQLException e) {
            System.out.println("Error al cargar nombres de equipos: " + e.getMessage());
        }
    }

    @FXML
    private void handleBtnConfirmar(ActionEvent event) {
        String id = EtiquetaIDJugador.getText();
        String nombre = EtiquetaNombre.getText();
        String apellidos = EtiquetaApellidos.getText();
        LocalDate fechaNacimiento = EtiquetaFechaNacimiento.getValue();
        String posicion = EtiquetaPosicion.getValue();
        String dorsalStr = EtiquetaDorsal.getText();
        String nombreEquipo = EtiquetaNombreEquipo.getValue();

        if (nombre == null || nombre.trim().isEmpty()
                || apellidos == null || apellidos.trim().isEmpty()
                || fechaNacimiento == null
                || posicion == null || posicion.trim().isEmpty()
                || dorsalStr == null || dorsalStr.trim().isEmpty()
                || nombreEquipo == null || nombreEquipo.trim().isEmpty()) {

            labelMensaje.setText("* Todos los campos son obligatorios.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        if (!comprobarFecha(fechaNacimiento)) {
            labelMensaje.setText("El jugador debe tener al menos 16 años.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        int dorsal;
        try {
            dorsal = Integer.parseInt(dorsalStr);
            if (!comprobarDorsal(dorsal)) {
                labelMensaje.setText("El dorsal debe ser un número entre 1 y 99.");
                labelMensaje.setStyle("-fx-text-fill: red;");
                return;
            }
        } catch (NumberFormatException e) {
            labelMensaje.setText("El dorsal debe ser un número.");
            labelMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            Jugador jugadorCreado = new Jugador(id, nombre, apellidos,
                    fechaNacimiento.toString(), posicion, dorsal, nombreEquipo);
            basedatos.modificarJugador(id, nombre, apellidos, fechaNacimiento.toString(),
                    posicion, dorsal, nombreEquipo);
            labelMensaje.setText("Jugador modificado correctamente");
            labelMensaje.setStyle("-fx-text-fill: white;");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                labelMensaje.setText("El jugador ya existe en la base de datos.");
                labelMensaje.setStyle("-fx-text-fill: red;");
            } else {
                labelMensaje.setText("Error al modificar el jugador: " + e.getMessage());
                labelMensaje.setStyle("-fx-text-fill: red;");
            }
        }
    }

}
