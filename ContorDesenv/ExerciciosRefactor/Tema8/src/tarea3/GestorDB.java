package tarea3;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDB {
    private Connection connection;
    public GestorDB() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el registro del driver" + e);
        }

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_tareas_db",
                    "usuarioGlobal", "abc123.");
            boolean isValid = conn.isValid(5000);
            System.out.println(isValid? "Conexión exitosa" : "Error en la conexión");

        } catch (SQLException e) {

            System.out.println(e);
        }
        connection = conn;
    }


    public static String iniciar() {
        String[] opciones = {"Agregar Tarea", "Marcar tarea como completada", "Ver lista de tareas", "Eliminar tarea", "Salir"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                "Gestión de tareas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return opcion;
    }

    public static void agregarTarea(GestorDB basedatos) throws SQLException {
        Statement st = basedatos.connection.createStatement();
        String nombreTarea = JOptionPane.showInputDialog("Introduzca el nombre de la tarea");
        String descripcion = JOptionPane.showInputDialog("Introduzca la descripción de la tarea");
        st.executeUpdate("INSERT INTO Tareas (nombre, descripcion) VALUES ('" + nombreTarea + "', '" + descripcion + "');");
        st.close();
        System.out.println("La tarea se ha registrado correctamente.");
    }

    public static void actualizarTarea(GestorDB basedatos) throws SQLException {
        Statement st = basedatos.connection.createStatement();
        System.out.println("Indique la tarea que quiera modificar");
        String tarea = JOptionPane.showInputDialog(null, "Indique el nombre de la tarea");
        st.executeUpdate("UPDATE Tareas SET completada = 1 WHERE nombre = '" + tarea + "';");
        System.out.println("Tarea modificada correctamente");
        st.close();
    }

    public static void verListaTareas(GestorDB basedatos) throws SQLException {
        Statement st = basedatos.connection.createStatement();
        String tarea = "";
        ResultSet rs = st.executeQuery("SELECT * FROM Tareas");
        while(rs.next()) {
            tarea += rs.getString("nombre") + "\n";
        }
        JOptionPane.showMessageDialog(null, tarea, "Lista de tareas", JOptionPane.ERROR_MESSAGE);
        rs.close();
    }

    public static void eliminarTarea(GestorDB basedatos) throws SQLException {
        PreparedStatement ps = basedatos.connection.prepareStatement("DELETE FROM Tareas WHERE nombre = ?");
        String tarea = JOptionPane.showInputDialog(null, "Escriba la tarea a eliminar");
        ps.setString(1, tarea);
        int modified = ps.executeUpdate();
        System.out.println("Se ha eliminado " + modified + " tareas");
    }
}
