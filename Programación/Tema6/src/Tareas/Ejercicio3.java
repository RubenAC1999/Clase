package Tareas;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {

        int[][] matriz = new int[4][5];

        Random generador = new Random();

        int numeroAleatorio = 0;
        int acumulador = 0;

        // Creador de la matriz y recuento de valores por filas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                numeroAleatorio = generador.nextInt(99);
                matriz[i][j] = numeroAleatorio;

                acumulador += numeroAleatorio;

                System.out.print(numeroAleatorio + "\t");
            }
            System.out.print("-> " + "[F" + i + " = " + acumulador + "]");

            acumulador = 0;

            System.out.println("\n");
        }

        // Recuento de valores por columna
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++){
                acumulador += matriz[j][i];

            }



        }




    }
}
