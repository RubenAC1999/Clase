package TareasRepaso.Tarea2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GestorDB {
    private Connection conexion;

    public GestorDB(Connection conexion) {
        this.conexion = conexion;
    }

    protected static int iniciarPrograma() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----BibliotecaDB---------");
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. Añadir libro");
        System.out.println("2. Añadir nuevo autor");
        System.out.println("3. Actualizar nombre de un autor");
        System.out.println("4. Mostrar libros y autores");
        System.out.println("5. Eliminar un libro");
        System.out.println("6. Salir");
        int respuesta = scanner.nextInt();
        return respuesta;
    }

    protected void anhadirLibro() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Indique el nombre del libro: ");
        String nombreLibro = scanner.nextLine();

        System.out.println("Indique el año de publicacion: ");
        int anhoPublicacion = scanner.nextInt();

        mostrarAutores();
        System.out.println("Indique el id de un autor existente en la base de datos: ");
        int idAutor = scanner.nextInt();
    }


    protected void mostrarAutores() {
        System.out.println("Lista de autores");
        String query = "SELECT * FROM autores";
        try {
            Statement st = conexion.createStatement();
            ResultSet autores = st.executeQuery(query);
            String autor = "";
            while (autores.next()){
               int id = autores.getInt("id");
               String nombre = autores.getString("nombre");
               String nacionalidad = autores.getString("nacionalidad");
               autor += "ID: " + String.valueOf(id) + " | Nombre: " + nombre + " | Nacionalidad: " + nacionalidad + "\n";
            }
            System.out.println(autor);
            autores.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error SQL " + e);
        }
    }
}
