package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;
    private String host;
    private String dbname;
    private String user;
    private String pass;
    private int port = 3306;
    private static DatabaseConnection database = null;

    public DatabaseConnection() throws SQLException {
        if (getConnection() != null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                this.connection = DriverManager.getConnection(("jdbc:mariadb://" + host + ":" + port + "/" + dbname), user, pass);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al cargar el driver");
            }
        }
    }

    public static DatabaseConnection getModel() throws SQLException {
        if (database == null) {
            DatabaseConnection.database = new DatabaseConnection();
        }

        return DatabaseConnection.database;
    }
    
    public void connect() throws SQLException {
        try {
                Class.forName("org.mariadb.jdbc.Driver");
                this.connection = DriverManager.getConnection(("jdbc:mariadb://" + host + ":" + port + "/" + dbname), user, pass);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al cargar el driver");
            }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
