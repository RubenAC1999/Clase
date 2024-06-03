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
import objetos.Partido;

public class ControllerPartidos {

    GestorDB basedatos;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button botonAnhadirPartido;
    @FXML
    private Label campoLogo;
    @FXML
    private TableView<Partido> tableView;
    @FXML
    private TableColumn<Partido, String> idColumn;
    @FXML
    private TableColumn<Partido, String> fechaColumn;
    @FXML
    private TableColumn<Partido, String> horaColumn;
    @FXML
    private TableColumn<Partido, String> resultadoColumn;
    @FXML
    private TableColumn<Partido, String> tipoColumn;
    @FXML
    private TableColumn<Partido, Void> actionColumn;
    @FXML
    private ObservableList<Partido> listaEquipos;

    public void initialize() {
        basedatos = new GestorDB();
        anchorPane.setStyle("-fx-background-image: url('/img/fondoMenus.png');");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        horaColumn.setCellValueFactory(new PropertyValueFactory<>("hora"));
        resultadoColumn.setCellValueFactory(new PropertyValueFactory<>("resultado"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        listaEquipos = FXCollections.observableArrayList();
        try {
            cargarDatos();
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos");
        }
        anhadirBotones();
    }

    private void cargarDatos() throws SQLException {
        ObservableList<Partido> listaPartidos = GestorDB.devolverPartidos();
        tableView.setItems(listaPartidos);
    }

    private void anhadirBotones() {
        Callback<TableColumn<Partido, Void>, TableCell<Partido, Void>> cellFactory = new Callback<TableColumn<Partido, Void>, TableCell<Partido, Void>>() {
            @Override
            public TableCell<Partido, Void> call(final TableColumn<Partido, Void> param) {
                final TableCell<Partido, Void> cell = new TableCell<Partido, Void>() {

                    private final Button btnModificar = new Button("Modificar");
                    private final Button btnBorrar = new Button("Eliminar");

                    {
                        btnModificar.setOnAction((event) -> {
                            Partido partido = getTableView().getItems().get(getIndex());
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/modificarPartido.fxml"));
                                Parent root = loader.load();

                                ControllerModificarPartido controller = loader.getController();
                                controller.setPartido(partido);

                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene(root));
                                stage.setTitle("Modificar Partido");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Modificar: " + partido);
                        });

                        btnBorrar.setOnAction((event) -> {
                            Partido partido = getTableView().getItems().get(getIndex());
                            Alert mensajeConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmar eliminación");
                            alert.setHeaderText("¿Estás seguro de que quieres eliminar este equipo?");
                            alert.setContentText(partido.getId());

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.isPresent() && result.get() == ButtonType.OK) {
                                basedatos.eliminarPatido(partido);
                                getTableView().getItems().remove(partido);
                                System.out.println("Eliminar: " + partido);
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
    private void handleCampoLogo(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) campoLogo.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/index.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();

        }

    }

    @FXML
    private void handleBtnAnhadirPartido(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) botonAnhadirPartido.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/anhadirPartido.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();

        }
    }
}
