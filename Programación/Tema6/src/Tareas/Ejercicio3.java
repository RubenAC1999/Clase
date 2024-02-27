package Tareas;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {

        int[][] matriz = new int[4][5];

        Random generador = new Random();

        int numeroAleatorio = 0;
        int acumuladorParcial = 0;
        int acumuladorTotal = 0;

        System.out.println("       +-----------------------------+");
        System.out.println("       |" +"\u001B[36m     Generador de matriz\u001B[37m     |");
        System.out.println("       +-----------------------------+");

        // Creador de la matriz y recuento de valores por filas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                numeroAleatorio = generador.nextInt(9);
                matriz[i][j] = numeroAleatorio;
                acumuladorParcial += numeroAleatorio;
                acumuladorTotal += numeroAleatorio;

                System.out.print("    " + numeroAleatorio + "    ");
            }

            System.out.print("--> " + "[F" + i + " = " + acumuladorParcial + "]");
            acumuladorParcial = 0;
            System.out.println();
        }

        System.out.println("    |        |        |        |        |     ");
        System.out.println("    v        v        v        v        v     ");

        // Recuento de valores por columna
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++){
                acumuladorParcial += matriz[j][i];
            }

            System.out.print("[C" + i + " = " + acumuladorParcial + "]" + "");
            acumuladorParcial = 0;
        }

        System.out.print("\u001B[36m   Total = " + acumuladorTotal);


    }
}
