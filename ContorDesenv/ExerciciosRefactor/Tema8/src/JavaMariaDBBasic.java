import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaMariaDBBasic {
    public void connectDatabase() {
        // registrar el driver de MariaDB;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el registro del driver" + e);
        }

        //Conexión a la Base de datos

        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/usuarios", "usuarioGlobal",
                    "abc123.");
            boolean valid = connection.isValid(5000);
            System.out.println(valid? "TEST OK" : "TEST FAIL");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void connecDatabase(String host, String port, String database, String user, String pwd) {
        try {
            //Registro al driver JDBC
            try {
                Class.forName("org.mariadb.jdbc.Driver");

            } catch (ClassNotFoundException e) {
                System.out.println("Error en el registro del driver JDBC" + e);
            }
            String url = "jdbc:mariadb://" + host + ":" + port + "/" + database;
            Connection connection = DriverManager.getConnection(url, user, pwd);
            boolean valid = connection.isValid(5000);
            System.out.println(valid? "TEST OK" : "TEST FAIL");

        } catch (SQLException f) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        JavaMariaDBBasic conn = new JavaMariaDBBasic();
        conn.connectDatabase();
        conn.connecDatabase("localhost", "3306", "usuarios", "usuarioGlobal", "abc123.");
    }

}
