package tarea3;

import javax.swing.*;
import java.sql.SQLException;

import static tarea3.GestorDB.*;

public class Main {
    public static void main(String[] args) {
        GestorDB basedatos = new GestorDB();

        switch (iniciar()) {
            case "Agregar Tarea":
                try {
                    agregarTarea(basedatos);
                    break;
                } catch (SQLException e) {
                    System.out.println(e);
                }

            case "Marcar tarea como completada":
                try {
                    actualizarTarea(basedatos);
                    break;
                } catch (SQLException e) {
                    System.out.println(e);
                }

            case "Ver lista de tareas":
                try {
                    verListaTareas(basedatos);
                    break;
                } catch (SQLException e) {
                    System.out.println(e);
                }

            case "Eliminar tarea":
                try {
                    eliminarTarea(basedatos);
                    break;
                } catch (SQLException e) {
                    System.out.println(e);
                }

            case "Salir":
                JOptionPane.showMessageDialog(null, "Finalizando programa...");
                System.exit(1);

        }

    }
}
