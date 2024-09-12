package TareasRepaso;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creador de matriz");
        System.out.println("-------------------");
        System.out.println("\nIntroduzca el número de filas: ");
        int filas = scanner.nextInt();
        System.out.println("Introduzca el número de columnas: ");
        int columnas = scanner.nextInt();

        char[][] matriz = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            System.out.println();

            for (int j = 0; j < columnas; j++) {

                if (j == 0 | j == (columnas - 1) | i == 0 | i == (filas - 1)) {
                    matriz[i][j] = '*';
                    System.out.print(matriz[i][j]);
                }
                else {
                    matriz[i][j] = '-';
                    System.out.print(matriz[i][j]);
                }
            }
        }

    }
}
