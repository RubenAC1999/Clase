package controllers;

import objetos.Equipo;
import database.GestorDB;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class ControllerEquipos {

    GestorDB basedatos;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button botonAnhadirEquipo;
    @FXML
    private Label campoLogo;
    @FXML
    private TableView<Equipo> tableView;
    @FXML
    private TableColumn<Equipo, String> nombreColumn;
    @FXML
    private TableColumn<Equipo, String> grupoColumn;
    @FXML
    private TableColumn<Equipo, Integer> fechaFundacionColumn;
    @FXML
    private TableColumn<Equipo, Void> actionColumn;
    @FXML
    private ObservableList<Equipo> listaEquipos;

    public void initialize() {
        basedatos = new GestorDB();
        anchorPane.setStyle("-fx-background-image: url('/img/fondoMenus.png');");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        grupoColumn.setCellValueFactory(new PropertyValueFactory<>("nombreGrupo"));
        fechaFundacionColumn.setCellValueFactory(new PropertyValueFactory<>("fechaFundacion"));

        listaEquipos = FXCollections.observableArrayList();
        try {
            cargarDatos();
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos");
        }

        anhadirBotones();
    }

    private void cargarDatos() throws SQLException {
        ObservableList<Equipo> listaEquipos = GestorDB.devolverEquipos();
        tableView.setItems(listaEquipos);
    }

    private void anhadirBotones() {
        Callback<TableColumn<Equipo, Void>, TableCell<Equipo, Void>> cellFactory = new Callback<TableColumn<Equipo, Void>, TableCell<Equipo, Void>>() {
            @Override
            public TableCell<Equipo, Void> call(final TableColumn<Equipo, Void> param) {
                final TableCell<Equipo, Void> cell = new TableCell<Equipo, Void>() {

                    private final Button btnModificar = new Button("Modificar");
                    private final Button btnBorrar = new Button("Eliminar");

                    {
                        btnModificar.setOnAction((event) -> {
                            Equipo equipo = getTableView().getItems().get(getIndex());
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/modificarEquipo.fxml"));
                                Parent root = loader.load();

                                ControllerModificarEquipo controller = loader.getController();
                                controller.setEquipo(equipo);

                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene(root));
                                stage.setTitle("Modificar Equipo");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Modificar: " + equipo);
                        });

                        btnBorrar.setOnAction((event) -> {
                            Equipo equipo = getTableView().getItems().get(getIndex());
                            Alert mensajeConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmar eliminación");
                            alert.setHeaderText("¿Estás seguro de que quieres eliminar este equipo?");
                            alert.setContentText(equipo.getNombre());

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.isPresent() && result.get() == ButtonType.OK) {
                                basedatos.eliminarEquipo(equipo);
                                getTableView().getItems().remove(equipo);
                                System.out.println("Eliminar: " + equipo);
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
    private void handleBtnAnhadirEquipo(MouseEvent event) throws SQLException, IOException {
        if (event.getButton() == MouseButton.PRIMARY) {
            Stage stage = (Stage) botonAnhadirEquipo.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/controllers/anhadirEquipo.fxml"));
            stage.setTitle("1RFEF Database");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
