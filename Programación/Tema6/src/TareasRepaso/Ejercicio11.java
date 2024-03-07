package TareasRepaso;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un número (" + (i + 1) + "/10)");
            numero = scanner.nextInt();

            numeros[i] = numero;
        }

        int indice = 1;
        for (int n : numeros) {
            System.out.println("Posición " + indice + ": " + n);
            indice++;
        }

    }
}
