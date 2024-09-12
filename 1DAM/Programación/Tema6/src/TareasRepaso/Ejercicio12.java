package TareasRepaso;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduzca la cantidad que desea que tenga el array");
        int capacidad = scanner.nextInt();
        int[] numeros = new int[capacidad];

        int acumulador = 0;
        for (int i = 0; i < capacidad; i++) {
            int numeroAleatorio = random.nextInt(9);
            numeros[i] = numeroAleatorio;
            System.out.println("Posición " + (i + 1) + ": " + numeros[i]);
            acumulador += numeroAleatorio;
        }

        System.out.println("La suma total de la lista es: " + acumulador);

    }
}
