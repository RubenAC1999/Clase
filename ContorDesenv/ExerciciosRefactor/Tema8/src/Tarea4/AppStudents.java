package Tarea4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import static Tarea4.ManageStudents.*;

public class AppStudents {
    public static void main(String[] args) {
        ManageStudents basedatos = new ManageStudents();
        openConnection();

        ArrayList<Student> listaEstudiantes = new ArrayList<>();
        Student estudiante1 = new Student("12345678A", "Pepe", "González", 19);
        listaEstudiantes.add(estudiante1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gestor de estudiantes");
        System.out.println("----------------------");
        System.out.println("1. Matricular un estudiante");
        System.out.println("2. Dar de baja a un estudiante");
        System.out.println("3. Actualizar datos de un estudiante");
        System.out.println("4. Ver datos de un estudiante");
        System.out.println("5. Ver datos de todos los estudiantes");
        System.out.println("6. Salir");
        System.out.println("-----------------------------");
        System.out.println("Seleccione una opción");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Introduzca el dni del estudiante que desea ingresar");
                String dni = scanner.nextLine();
                for(Student estudiante : listaEstudiantes) {
                    if (estudiante.getDni().equalsIgnoreCase(dni)) {
                        try {
                            addStudent(estudiante);
                            System.out.println("Estudiante " + estudiante.getName() + " con DNI: " + estudiante.getDni() +
                                    " ingresado correctamente.");
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                    }
                }
        }
    }
}
