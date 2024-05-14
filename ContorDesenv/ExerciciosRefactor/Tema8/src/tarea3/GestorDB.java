package tarea3;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class GestorDB {
    public Connection connection = null;
    public GestorDB() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el registro del driver" + e);
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_tareas_db",
                    "usuarioGlobal", "abc123.");
            boolean isValid = connection.isValid(5000);
            System.out.println(isValid? "Conexión exitosa" : "Error en la conexión");

        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
        connection = conn;
    }


    public static void iniciar() {
        String[] opciones = {"Agregar Tarea", "Marcar tarea como completada", "Ver lista de tareas", "Eliminar tarea"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                "Gestión de tareas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
    }

    public static void agregarTarea(GestorDB basedatos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la tarea");
        String nombreTarea = scanner.nextLine();
        Statement st = basedatos.connection.createStatement("")
    }
}
