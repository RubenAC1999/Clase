package tarea3;

import java.sql.*;
import javax.swing.JOptionPane;
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
        String[] opciones = {"Agregar Tarea", "Marcar tarea como completada", "Ver lista de tareas", "Eliminar tarea"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                "Gestión de tareas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return opcion;
    }

    public static void agregarTarea(GestorDB basedatos) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Statement st = basedatos.connection.createStatement();
        System.out.println("Introduzca el nombre de la tarea");
        String nombreTarea = scanner.nextLine();
        System.out.println("Introduzca la descripción de la tarea");
        String descripcion = scanner.nextLine();
        st.executeUpdate("INSERT INTO Tareas (nombre, descripcion) VALUES ('" + nombreTarea + "', '" + descripcion + "');");
        st.close();
        System.out.println("La tarea se ha registrado correctamente.");
    }
}
