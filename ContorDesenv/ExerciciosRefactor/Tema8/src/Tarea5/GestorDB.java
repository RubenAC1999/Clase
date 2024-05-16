package Tarea5;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.sql.*;


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
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/notaria_test",
                    "usuarioGlobal", "abc123.");
            boolean isValid = conn.isValid(5000);
            System.out.println(isValid? "Conexión exitosa" : "Error en la conexión");

        } catch (SQLException e) {

            System.out.println(e);
        }
        connection = conn;
    }
    public static String iniciar() {
        String[] opciones = {"Crear tabla", "Insertar datos", "Recuperar datos", "Actualizar tabla Clientes"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                "Gestor de notaría", JOptionPane.QUESTION_MESSAGE, null, opciones,opciones[0]);

        return opcion;
    }

    public static void crearTabla(GestorDB basedatos) throws SQLException {
        Statement st = basedatos.connection.createStatement();
            st.executeQuery("ALTER TABLE EscCli DROP FOREIGN KEY esccli_ibfk_1;");
            st.executeQuery("ALTER TABLE EscCli DROP FOREIGN KEY esccli_ibfk_2;");
            st.executeQuery("CREATE OR REPLACE TABLE Clientes (Cod_Cliente INT NOT NULL AUTO_INCREMENT, Nombre VARCHAR(255), Telefono VARCHAR(15), PRIMARY KEY (Cod_Cliente));");
            st.executeQuery("CREATE OR REPLACE TABLE Escrituras (Codigo INT NOT NULL AUTO_INCREMENT, Tipo VARCHAR(50), Nom_fich VARCHAR(255), Num_interv INT, PRIMARY KEY (Codigo));");
            st.executeQuery("CREATE OR REPLACE TABLE EscCli (codCli INT, codEsc INT, FOREIGN KEY (codCli) REFERENCES Clientes(Cod_Cliente), FOREIGN KEY (codEsc) REFERENCES Escrituras(Codigo));");
        JOptionPane.showMessageDialog(null, "Tablas creadas correctamente.");
        st.close();
        basedatos.connection.close();
    }

    public static void insertarDatos(GestorDB basedatos) throws SQLException {
        String[] tablas = {"Clientes", "Escrituras y EscCli"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione la tabla para insertar datos",
                "Gestor de notaría", JOptionPane.QUESTION_MESSAGE, null, tablas,tablas[0]);
        if (opcion.equals("Clientes")) {
            String nombre = JOptionPane.showInputDialog(null, "Indique el nombre del cliente");
            String telefono = JOptionPane.showInputDialog(null, "Indique el telefono del cliente");
            String sentencia = "INSERT INTO Clientes (Nombre, Telefono) VALUES (?, ?)";
            PreparedStatement pst = basedatos.connection.prepareStatement(sentencia);
            pst.setString(1, nombre);
            pst.setString(2, telefono);
            pst.executeQuery();
            pst.close();
            basedatos.connection.close();

        }
        if (opcion.equals("Escrituras y EscCli")) {
            String tipo = JOptionPane.showInputDialog(null, "Indique el tipo de escritura");
            String nomFicha = JOptionPane.showInputDialog(null, "Indique el nombre del fichero");
            String intervinientes = JOptionPane.showInputDialog(null, "Indique el número de intervinientes");
            String codigoCliente = JOptionPane.showInputDialog(null, "Indique código del cliente");
            int numInt = Integer.parseInt(intervinientes);
            int numCodCliente = Integer.parseInt(codigoCliente);

            String sentencia = "INSERT INTO Escrituras (Tipo, Nom_fich, Num_interv) VALUES (?, ?, ?)";
            PreparedStatement pst = basedatos.connection.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, tipo);
            pst.setString(2, nomFicha);
            pst.setInt(3, numInt);
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int codigoEscritura = 0;
            if (rs.next()) {
                codigoEscritura = rs.getInt(1);
            }
            sentencia = "INSERT INTO EscCli (codCli, codEsc) VALUES (?, ?)";
            pst = basedatos.connection.prepareStatement(sentencia);
            pst.setInt(1, numCodCliente);
            pst.setInt(2, codigoEscritura);
            pst.executeQuery();
            rs.close();
            pst.close();
            basedatos.connection.close();

        }

    }
    public static void recuperarDatos(GestorDB basedatos) throws SQLException {
        String[] tablas = {"Clientes", "Escrituras"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione la tabla para recuperar los datos",
                "Gestor de notaría", JOptionPane.QUESTION_MESSAGE, null, tablas,tablas[0]);
        Statement st = basedatos.connection.createStatement();
        if (opcion.equals("Clientes")) {
            String cliente = "";
            ResultSet rs = st.executeQuery("SELECT * FROM Clientes");
            while(rs.next()) {
                cliente += rs.getString("Cod_Cliente") + "   "
                        + rs.getString("Nombre") + "   "
                        + rs.getString("Telefono") + "   "
                        + "\n";
            }
            JOptionPane.showMessageDialog(null, cliente, "Lista de clientes", JOptionPane.ERROR_MESSAGE);
            rs.close();
            basedatos.connection.close();

        }
        if (opcion.equals("Escrituras")) {
            String escrituras = "";
            ResultSet rs = st.executeQuery("SELECT * FROM Escrituras");
            while(rs.next()) {
                escrituras += rs.getString("Codigo") + "   "
                        + rs.getString("Tipo") + "   "
                        + rs.getString("Nom_fich") + "   "
                        + rs.getInt("Num_interv") + "   "
                        +    "\n";
            }
            JOptionPane.showMessageDialog(null, escrituras, "Lista de Escrituras", JOptionPane.ERROR_MESSAGE);
            rs.close();
            basedatos.connection.close();

        }

    }

    public static void actualizarCliente(GestorDB basedatos) throws SQLException{
        String codigo = JOptionPane.showInputDialog(null, "Introduzca el código de cliente");
        int numCodigo = Integer.parseInt(codigo);
        String[] tablas = {"Nombre", "Telefono"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Que dato desea cambiar",
                "Gestor de notaría", JOptionPane.QUESTION_MESSAGE, null, tablas,tablas[0]);
        if (opcion.equals("Nombre")) {
            String nombre = JOptionPane.showInputDialog(null, "Indique el nuevo nombre");
            PreparedStatement pst = basedatos.connection.prepareStatement("UPDATE Clientes SET Nombre = ? WHERE Cod_Cliente = ?;");
            pst.setString(1, nombre);
            pst.setInt(2, numCodigo);
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Dato modificado correctamente.");
            basedatos.connection.close();

        } else if (opcion.equals("Telefono")) {
            String telefono = JOptionPane.showInputDialog(null, "Indique el nuevo telefono");
            PreparedStatement pst = basedatos.connection.prepareStatement("UPDATE Clientes SET Telefono = ? WHERE Cod_Cliente = ?;");
            pst.setString(1, telefono);
            pst.setInt(2, numCodigo);
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Dato modificado correctamente.");
            basedatos.connection.close();

        }
    }
}
