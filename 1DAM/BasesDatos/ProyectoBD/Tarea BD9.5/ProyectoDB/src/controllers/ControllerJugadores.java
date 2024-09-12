package controllers;

import database.GestorDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import objetos.Jugador;

public class ControllerJugadores {

    GestorDB basedatos;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button botonAnhadirJugador;
    @FXML
    private Label campoLogo;
    @FXML
    private TableView<Jugador> tableView;
    @FXML
    private TableColumn<Jugador, String> nombreColumn;
    @FXML
    private TableColumn<Jugador, String> apellidosColumn;
    @FXML
    private TableColumn<Jugador, Integer> fechaNacimientoColumn;
    @FXML
    private TableColumn<Jugador, String> posicionColumn;
    @FXML
    private TableColumn<Jugador, Integer> dorsalColumn;
    @FXML
    private TableColumn<Jugador, String> nombreEquipoColumn;
    @FXML
    private TableColumn<Jugador, Void> actionColumn;
    @FXML
    private ObservableList<Jugador> listaJugadores;

    public void initialize() {
        basedatos = new GestorDB();
        anchorPane.setStyle("-fx-background-image: url('/img/fondoMenus.png');");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidosColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        fechaNacimientoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        posicionColumn.setCellValueFactory(new PropertyValueFactory<>("posicion"));
        dorsalColumn.setCellValueFactory(new PropertyValueFactory<>("dorsal"));
        nombreEquipoColumn.setCellValueFactory(new PropertyValueFactory<>("nombreEquipo"));

        listaJugadores = FXCollections.observableArrayList();
        try {
            cargarDatos();
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos");
        }

        anhadirBotones(); 
    }

    @FXML
    private void handleCampoLogo(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) campoLogo.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/index.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    private void anhadirBotones() {
        Callback<TableColumn<Jugador, Void>, TableCell<Jugador, Void>> cellFactory = new Callback<TableColumn<Jugador, Void>, TableCell<Jugador, Void>>() {
            @Override
            public TableCell<Jugador, Void> call(final TableColumn<Jugador, Void> param) {
                final TableCell<Jugador, Void> cell = new TableCell<Jugador, Void>() {

                    private final Button btnModificar = new Button("Modificar");
                    private final Button btnBorrar = new Button("Eliminar");

                    {
                        btnModificar.setOnAction((event) -> {
                            Jugador jugador = getTableView().getItems().get(getIndex());
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/modificarJugador.fxml"));
                                Parent root = loader.load();

                                ControllerModificarJugador controller = loader.getController();
                                controller.setJugador(jugador);

                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene(root));
                                stage.setTitle("Modificar Jugador");
                                stage.show();
                            } catch (IOException e) {
                                e.getMessage();
                            }
                        });

                        btnBorrar.setOnAction((event) -> {
                            Jugador jugador = getTableView().getItems().get(getIndex());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmar eliminación");
                            alert.setHeaderText("¿Estás seguro de que quieres eliminar este jugador?");
                            alert.setContentText(jugador.getNombre() + " " + jugador.getApellidos());

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.isPresent() && result.get() == ButtonType.OK) {
                                basedatos.eliminarJugador(jugador);
                                getTableView().getItems().remove(jugador);
                                System.out.println("Eliminar: " + jugador);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox pane = new HBox(btnModificar, btnBorrar);
                            setGraphic(pane);
                        }
                    }
                };
                return cell;
            }
        };

        actionColumn.setCellFactory(cellFactory);
    }

    @FXML
    private void handleBtnAnhadirJugador(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) botonAnhadirJugador.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/anhadirJugador.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    private void cargarDatos() throws SQLException {
        ObservableList<Jugador> listaJugadores = GestorDB.devolverJugadores();
        tableView.setItems(listaJugadores);
    }
}
