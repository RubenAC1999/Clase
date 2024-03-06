package TareasRepaso;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el número de alumnos: ");
        int numAlumnos = scanner.nextInt();

        System.out.println("Introduzca el número de materias: ");
        int numMaterias = scanner.nextInt();

        float[][] notas = new float[numAlumnos][numMaterias];

        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Notas del alumno " + (i + 1) + ".");
            System.out.println("----------------------------------");

            for (int j = 0; j < numMaterias; j++) {
                System.out.println("Materia " + (j + 1) + ": ");
                notas[i][j] = scanner.nextFloat();
            }

        }

       for (int i = 0; i < numMaterias; i++) {
           if (i == 0) {
               System.out.print("\t\t\tMateria " + (i + 1));
               continue;
           }
            System.out.print("\tMateria " + (i + 1));
       }

       System.out.print("\t\tPromedio\t\t\tCualificación más alta\t\t\tCualificación más baja");
       float[] notasOrdenacionAlumno = new float[numMaterias];

       for (int i = 0; i < numAlumnos; i++) {
           float promedioAlumno;
           float acumulador = 0;
           System.out.print("\nAlumno " + (i + 1) + " :\t   ");

           for (int j = 0; j < numMaterias; j++) {
               System.out.printf("%-12.2f", notas[i][j]);
               acumulador += notas[i][j];
               notasOrdenacionAlumno[j] = notas[i][j];
           }

           Arrays.sort(notasOrdenacionAlumno);
           float cualificacionAlta = notasOrdenacionAlumno[numMaterias - 1];
           float cualificacionBaja = notasOrdenacionAlumno[0];
           promedioAlumno = acumulador / numMaterias;
           System.out.printf("%8.2f %25.2f %32.2f", promedioAlumno, cualificacionAlta, cualificacionBaja);
       }

       float[][] notasOrdenacionMateria = new float[numAlumnos][numMaterias];
       System.out.println("\n------------------------------------------");
       System.out.print("\nPr.Materia:\t  ");

       for (int i = 0; i < numMaterias; i++) {
           float acumulador = 0;
           float promedioMateria;
           for (int j = 0; j < numAlumnos; j++) {
               acumulador += notas[j][i];
               notasOrdenacionMateria[i][j] = notas[j][i];
           }
           promedioMateria = acumulador / numAlumnos;
           System.out.printf("%-12.2f", promedioMateria);
       }

       for (int i = 0; i < notasOrdenacionMateria.length; i++) {
           Arrays.sort(notasOrdenacionMateria[i]);
       }

       System.out.print("\nCual.Baja:\t  ");
       for (int i = 0; i < numMaterias; i++) {
           System.out.printf("%-12.2f", notasOrdenacionMateria[i][0]);
       }

        System.out.print("\nCual.Alta:\t  ");
        for (int i = 0; i < numMaterias; i++) {
            System.out.printf("%-12.2f", notasOrdenacionMateria[i][numMaterias-1]);
        }


    }
}
