package TareasRepaso.Tarea2;
import org.mariadb.jdbc.export.Prepare;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GestorDB {
    private static Connection conexion;

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
        try {
            if (!autorExiste(idAutor)) {
                System.out.println("El ID indicado no existe en la base de datos.");
                System.out.println("Debes añadir el autor nuevo o indicar un ID existente en la base de datos.");
            } else {
                String query = "INSERT INTO libros (titulo, id_autor, anio_publicacion) VALUES (?, ?, ?)";
                PreparedStatement preparedQuery = conexion.prepareStatement(query);
                preparedQuery.setString(1, nombreLibro);
                preparedQuery.setInt(2, idAutor);
                preparedQuery.setInt(3, anhoPublicacion);
                preparedQuery.executeUpdate();
                System.out.println("Libro añadido correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL " + e);
        }

    }

    protected void anhadirAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique el nombre del nuevo autor: ");
        String nombre = scanner.nextLine();

        System.out.println("Indique la nacionalidad del nuevo autor: ");
        String nacionalidad = scanner.nextLine();

        String query = "INSERT INTO autores (nombre, nacionalidad) VALUES (?, ?)";
        try {
            PreparedStatement preparedQuery = conexion.prepareStatement(query);
            preparedQuery.setString(1, nombre);
            preparedQuery.setString(2, nacionalidad);
            preparedQuery.executeUpdate();
            System.out.println("Autor añadido correctamente.");

        } catch(SQLException e) {
            System.out.println("Error SQL " + e);
        }

    }

    protected void actualizarAutor() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        try {
            System.out.println("Indique el id del autor a actualizar");
            mostrarAutores();
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("ID no válido");
        }
        try {
            if (!autorExiste(id)) {
                System.out.println("El autor con el ID indicado no existe.");

            } else {
                System.out.println("ID correcto.");
                String nombre = "";
                System.out.println("Indique el nuevo nombre a añadir: ");
                nombre = scanner.nextLine();
                if (!comprobarNombre(nombre)) {
                    System.out.println("El nombre introducido no es válido (debe contener solo letras).");
                } else {
                    try {
                        String query = "UPDATE autores SET nombre = ? WHERE id = ?";
                        PreparedStatement preparedQuery = conexion.prepareStatement(query);
                        preparedQuery.setString(1, nombre);
                        preparedQuery.setInt(2, id);
                        preparedQuery.executeUpdate();
                        System.out.println("El usuario se ha modificado correctamente.");
                    } catch (SQLException e) {
                        System.out.println("Error SQL " + e);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    protected static boolean autorExiste(int id) throws SQLException{
        Statement query = conexion.createStatement();
        ResultSet autores = query.executeQuery("SELECT * FROM autores");
        while(autores.next()) {
            if (autores.getInt("id") == id) {
                autores.close();
                query.close();
                return true;
            }
        }
        return false;
    }

    private static boolean comprobarNombre(String nombre) {
        String regex = "^[a-zA-Z]+$";
        Pattern patron = Pattern.compile(regex);

        return patron.matcher(nombre).matches();
    }

    protected void mostrarLibrosYAutores() {
        String query = "SELECT a.id, l.titulo, l.anio_publicacion FROM autores a INNER JOIN libros l ON a.id = l.id_autor";
        String lista = "";
        try {
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery(query);

            while (rs.next()) {
                String idAutor = String.valueOf(rs.getInt("id"));
                String titulo = rs.getString("titulo");
                String anho = String.valueOf(rs.getInt("anio_publicacion"));
                lista += "ID Autor: " + idAutor + " | Título: " + titulo + " | Año de publicación: " + anho + "\n";
            }
            rs.close();
            consulta.close();
            System.out.println(lista);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /* Ejemplo de otro patrón
    String regex = "^[A-Z]{4}\\d{4}$";
    String input = "ABCD1234";*/
}
