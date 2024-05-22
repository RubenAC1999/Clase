package TareasRepaso.Tarea2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
   private String nombreBaseDatos;
   private String usuario;
   private String contrasenha;
   private Connection conexion;

    public ConexionDB(String nombreBaseDatos, String usuario, String contrasenha) {
        this.nombreBaseDatos = nombreBaseDatos;
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }
    public void abrirConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/" + nombreBaseDatos;
            conexion = DriverManager.getConnection(url, usuario, contrasenha);
            System.out.println("Conexión establecida con éxito a " + nombreBaseDatos);

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MariaDB: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos " + nombreBaseDatos + ": " + e.getMessage());
        }
    }

    public void cerrarConection() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión " + e);
            }
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}


