package Tarea4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ManageStudents {
    private static Connection conn;

    public ManageStudents() {
    }

    public static void openConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el registro del driver" + e);
        }

        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/school",
                    "usuarioGlobal", "abc123.");
            boolean isValid = conn.isValid(5000);
            System.out.println(isValid? "Conexión exitosa" : "Error en la conexión");

        } catch (SQLException e) {

            System.out.println(e);
        }
        ManageStudents.conn = conn;

    }

    public static void closeConnection() {
        conn = null;
    }

    public static boolean addStudent(Student student) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO student (dni, name, surname, age) VALUES ('" + student.getDni() + "', '" +
                student.getName() + "', '" + student.getSurname() + "', " + + student.getAge() + ");");
        st.close();
        return true;
    }
}
