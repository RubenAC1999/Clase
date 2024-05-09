import java.sql.*;
import java.util.Scanner;

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
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados", "usuarioGlobal",
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

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        JavaMariaDBBasic conn = new JavaMariaDBBasic();

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empleados", "usuarioGlobal", "abc123.");

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM emp");

        while(rs.next()) {
            System.out.println(rs.getInt("NUMDEP") + "\t"
                    + rs.getString("NOEMP") + "\t"
                    + rs.getString("PUESTO") + "\t"
                    + rs.getDate("FECCONT") + "\t"
                    + rs.getDouble("SAL") + "\t"
                    + rs.getDouble("COMISION") + "\t");
        }
        rs.close();

        int update = statement.executeUpdate("UPDATE emp SET NOEMP = 'BONIFACIO' WHERE NUMEMP = 7499");
        System.out.println("Se modificaron los registros " + update + " registros");

        rs = statement.executeQuery("SELECT * FROM emp WHERE NUMEMP = 7499");

        while(rs.next()) {
            System.out.println(rs.getInt("NUMDEP") + "\t"
                    + rs.getString("NOEMP") + "\t"
                    + rs.getString("PUESTO") + "\t"
                    + rs.getDate("FECCONT") + "\t"
                    + rs.getDouble("SAL") + "\t"
                    + rs.getDouble("COMISION") + "\t"
                    + rs.getInt("NUMEMP"));
        }
        rs.close();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM emp WHERE NOEMP LIKE ?");
        System.out.println("Introduzca la letra: ");
        String letra = scanner.nextLine();
        ps.setString(1, letra.toUpperCase() + "%");

        rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt("NUMDEP") + "\t"
                    + rs.getString("NOEMP") + "\t"
                    + rs.getString("PUESTO") + "\t"
                    + rs.getDate("FECCONT") + "\t"
                    + rs.getDouble("SAL") + "\t"
                    + rs.getDouble("COMISION") + "\t"
                    + rs.getInt("NUMEMP"));
        }
        rs.close();

    }



}
