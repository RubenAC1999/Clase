package tarea3;

import java.sql.SQLException;

import static tarea3.GestorDB.*;

public class Main {
    public static void main(String[] args) {
        GestorDB basedatos = new GestorDB();

        switch (iniciar()) {
            case "Agregar Tarea":
                try {
                    agregarTarea(basedatos);
                } catch (SQLException e) {
                    System.out.println(e);
                }

        }

    }
}
