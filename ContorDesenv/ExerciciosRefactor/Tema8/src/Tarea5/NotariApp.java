package Tarea5;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

import java.sql.SQLException;

import static Tarea5.GestorDB.*;

public class NotariApp {
    public static void main(String[] args) {
        GestorDB basedatos = new GestorDB();

        switch (iniciar()) {
            case "Crear tabla":
                try {
                    crearTabla(basedatos);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
            case "Insertar datos":
                try {
                    insertarDatos(basedatos);
                } catch (SQLException e) {

                }
                break;

            case "Recuperar datos":
                try {
                    recuperarDatos(basedatos);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
        }

    }
}
