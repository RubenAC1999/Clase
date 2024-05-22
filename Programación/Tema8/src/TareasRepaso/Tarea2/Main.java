package TareasRepaso.Tarea2;

public class Main {
    public static void main(String[] args) {
        ConexionDB conexionDB = new ConexionDB("biblioteca", "usuarioGlobal", "abc123.");
        conexionDB.abrirConexion();

        GestorDB baseDatos = new GestorDB(conexionDB.getConexion());

        int respuesta = GestorDB.iniciarPrograma();

        baseDatos.mostrarAutores();
    }
}
