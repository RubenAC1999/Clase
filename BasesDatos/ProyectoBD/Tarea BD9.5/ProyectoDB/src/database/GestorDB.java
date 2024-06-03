package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objetos.Equipo;
import objetos.Jugador;
import objetos.Partido;

public class GestorDB {

    private static Connection connection;

    private static void openConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException classnotfound) {
            System.out.println("Error al cargar el driver \n" + classnotfound);
        }

        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/competicion_deportiva",
                    "usuarioGlobal", "abc123.");
        } catch (SQLException sqlexception) {
            System.out.println("Error al conectar con la base de datos \n" + sqlexception);
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqlexception) {
            System.out.println("Error al cerrar la conexión \n" + sqlexception);
        }
    }

    public static ObservableList<Equipo> devolverEquipos() {
        ObservableList<Equipo> listaEquipos = FXCollections.observableArrayList();
        openConnection();
        String query = "SELECT * FROM Equipos";
        try {
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            ResultSet equipos = preparedQuery.executeQuery();
            while (equipos.next()) {
                String nombre = equipos.getString("nombreEquipo");
                String estadio = equipos.getString("estadio");
                String direccion = equipos.getString("direccion");
                int capacidad = equipos.getInt("capacidad");
                int fechaFundacion = equipos.getInt("fechaFundacion");
                String nombreGrupo = equipos.getString("nombreGrupo");
                listaEquipos.add(new Equipo(nombre, estadio, direccion, capacidad, fechaFundacion, nombreGrupo));
            }
        } catch (SQLException sqlexception) {
            System.out.println("Error SQL \n" + sqlexception);
        } finally {
            closeConnection();
        }
        return listaEquipos;
    }

    public void insertarNuevoEquipo(Equipo equipo) throws SQLException {
        openConnection();
        String query = "INSERT INTO Equipos (nombreEquipo, estadio, direccion, capacidad, fechaFundacion, nombreGrupo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedQuery = connection.prepareStatement(query)) {
            preparedQuery.setString(1, equipo.getNombre());
            preparedQuery.setString(2, equipo.getEstadio());
            preparedQuery.setString(3, equipo.getDireccion());
            preparedQuery.setInt(4, equipo.getCapacidad());
            preparedQuery.setInt(5, equipo.getFechaFundacion());
            preparedQuery.setString(6, equipo.getNombreGrupo());
            preparedQuery.executeUpdate();
        }
        closeConnection();
    }

    public void insertarNuevoJugador(Jugador jugador) throws SQLException {
        openConnection();
        String query = "INSERT INTO Jugadores (IDJugador, nombre, apellidos, fechaNacimiento,"
                + " posicion, dorsal, nombreEquipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedQuery = connection.prepareStatement(query)) {
            preparedQuery.setString(1, jugador.getId());
            preparedQuery.setString(2, jugador.getNombre());
            preparedQuery.setString(3, jugador.getApellidos());
            preparedQuery.setString(4, jugador.getFechaNacimiento());
            preparedQuery.setString(5, jugador.getPosicion());
            preparedQuery.setInt(6, jugador.getDorsal());
            preparedQuery.setString(7, jugador.getNombreEquipo());
            preparedQuery.executeUpdate();
        }
        closeConnection();
    }

    public void insertarNuevoPartido(Partido partido) throws SQLException {
        openConnection();
        String query = "INSERT INTO Partidos (IDPartido, fecha, hora, resultado,"
                + " tipo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedQuery = connection.prepareStatement(query)) {
            preparedQuery.setString(1, partido.getId());
            preparedQuery.setString(2, partido.getFecha());
            preparedQuery.setString(3, partido.getHora());
            preparedQuery.setString(4, partido.getResultado());
            preparedQuery.setString(5, partido.getTipo());
            preparedQuery.executeUpdate();
        }
        closeConnection();
    }

    public static ObservableList<Jugador> devolverJugadores() {
        ObservableList<Jugador> listaJugadores = FXCollections.observableArrayList();
        openConnection();
        String query = "SELECT * FROM Jugadores";
        try {
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            ResultSet jugadores = preparedQuery.executeQuery();
            while (jugadores.next()) {
                String id = jugadores.getString("IDJugador");
                String nombre = jugadores.getString("nombre");
                String apellidos = jugadores.getString("apellidos");
                String fechaNacimiento = jugadores.getString("fechaNacimiento");
                String posicion = jugadores.getString("posicion");
                int dorsal = jugadores.getInt("dorsal");
                String nombreEquipo = jugadores.getString("nombreEquipo");
                listaJugadores.add(new Jugador(id, nombre, apellidos, fechaNacimiento, posicion, dorsal, nombreEquipo));
            }
        } catch (SQLException sqlexception) {
            System.out.println("Error SQL \n" + sqlexception);
        }
        return listaJugadores;
    }

    public static ObservableList<Partido> devolverPartidos() {
        ObservableList<Partido> listaPartidos = FXCollections.observableArrayList();
        openConnection();
        String query = "SELECT * FROM Partidos";
        try {
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            ResultSet partidos = preparedQuery.executeQuery();
            while (partidos.next()) {
                String id = partidos.getString("IDPartido");
                String fecha = partidos.getString("fecha");
                String hora = partidos.getString("hora");
                String resultado = partidos.getString("resultado");
                String tipo = partidos.getString("tipo");
                listaPartidos.add(new Partido(id, fecha, hora, resultado, tipo));
            }
        } catch (SQLException sqlexception) {
            System.out.println("Error SQL \n" + sqlexception);
        }
        return listaPartidos;
    }

    public boolean existeEquipo(String nombreEquipo) {
        String query = "SELECT COUNT(*) FROM Equipos WHERE nombreEquipo = ?";
        try (PreparedStatement preparedQuery = connection.prepareStatement(query)) {
            preparedQuery.setString(1, nombreEquipo);
            try (ResultSet equipo = preparedQuery.executeQuery()) {
                if (equipo.next()) {
                    int count = equipo.getInt(1);
                    System.out.println("Existe equipo: " + (count > 0));
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return false;
    }

    public boolean existeJugador(String idJugador) {
        String query = "SELECT COUNT(*) FROM Jugadores WHERE IDJugador = ?";
        try (PreparedStatement preparedQuery = connection.prepareStatement(query)) {
            preparedQuery.setString(1, idJugador);
            try (ResultSet equipo = preparedQuery.executeQuery()) {
                if (equipo.next()) {
                    int count = equipo.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return false;
    }

    public boolean existePartido(String idPartido) {
        String query = "SELECT COUNT(*) FROM Partidos WHERE IDPartido = ?";
        try (PreparedStatement preparedQuery = connection.prepareStatement(query)) {
            preparedQuery.setString(1, idPartido);
            try (ResultSet equipo = preparedQuery.executeQuery()) {
                if (equipo.next()) {
                    int count = equipo.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return false;
    }

    public List<String> obtenerNombresEquipos() throws SQLException {
        openConnection();
        List<String> nombresEquipos = new ArrayList<>();
        String query = "SELECT nombreEquipo FROM Equipos";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                nombresEquipos.add(resultSet.getString("nombreEquipo"));
            }
        }
        closeConnection();
        return nombresEquipos;

    }

    public void modificarEquipo(String nombreEquipo, String estadio, String direccion,
            String capacidad, String fechaFundacion, String nombreGrupo,
            String nombreAnterior) throws SQLException {
        openConnection();

        String query = "UPDATE Equipos SET nombreEquipo = ?, estadio = ?, "
                + "direccion = ?, capacidad = ?, fechaFundacion = ?, "
                + "nombreGrupo = ? WHERE nombreEquipo = ?";

        PreparedStatement preparedQuery = connection.prepareStatement(query);
        preparedQuery.setString(1, nombreEquipo);
        preparedQuery.setString(2, estadio);
        preparedQuery.setString(3, direccion);
        preparedQuery.setInt(4, Integer.parseInt(capacidad));
        preparedQuery.setInt(5, Integer.parseInt(fechaFundacion));
        preparedQuery.setString(6, nombreGrupo);
        preparedQuery.setString(7, nombreAnterior);
        preparedQuery.executeUpdate();
        closeConnection();
    }

    public void modificarPartido(String IDPartido, String fecha, String hora,
            String resultado, String tipo) throws SQLException {
        openConnection();

        String query = "UPDATE Partidos SET fecha = ?, hora = ?, "
                + "resultado = ?, tipo = ? WHERE IDPArtido = ?";

        PreparedStatement preparedQuery = connection.prepareStatement(query);
        preparedQuery.setString(1, fecha);
        preparedQuery.setString(2, hora);
        preparedQuery.setString(3, resultado);
        preparedQuery.setString(4, tipo);
        preparedQuery.setString(5, IDPartido);
        preparedQuery.executeUpdate();
        closeConnection();
    }

    public void modificarJugador(String IDJugador, String nombre, String apellidos,
            String fechaNacimiento, String posicion, int dorsal, String nombreEquipo)
            throws SQLException {
        openConnection();

        String query = "UPDATE Jugadores SET nombre = ?, apellidos = ?, "
                + "fechaNacimiento = ?, posicion = ?, dorsal = ?, "
                + "nombreEquipo = ? WHERE IDJugador = ?";

        PreparedStatement preparedQuery = connection.prepareStatement(query);
        preparedQuery.setString(1, nombre);
        preparedQuery.setString(2, apellidos);
        preparedQuery.setString(3, fechaNacimiento);
        preparedQuery.setString(4, posicion);
        preparedQuery.setInt(5, dorsal);
        preparedQuery.setString(6, nombreEquipo);
        preparedQuery.setString(7, IDJugador);
        preparedQuery.executeUpdate();
        closeConnection();
    }

    public void eliminarEquipo(Equipo equipo) {
        openConnection();
        try {
            String query = "DELETE FROM Equipos WHERE nombreEquipo = ?";
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            preparedQuery.setString(1, equipo.getNombre());
            preparedQuery.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL : " + e.getMessage());
        }
        closeConnection();

    }

    public void eliminarPatido(Partido partido) {
        openConnection();
        try {
            String query = "DELETE FROM Partidos WHERE IDPartido = ?";
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            preparedQuery.setString(1, partido.getId());
            preparedQuery.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL : " + e.getMessage());
        }
        closeConnection();
    }

    public void eliminarJugador(Jugador jugador) {
        openConnection();
        try {
            String query = "DELETE FROM Jugadores WHERE IDJugador = ?";
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            preparedQuery.setString(1, jugador.getId());
            preparedQuery.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error SQL : " + e.getMessage());
        }
        closeConnection();
    }

}
