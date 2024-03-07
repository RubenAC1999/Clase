package TareasRepaso;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Establezca el límite para la impresión de números primos: ");
        int cantidad = scanner.nextInt();
        int[] numeros = new int[cantidad];

        for (int i = 0; i < numeros.length; i++) {
            int numeroAleatorio = random.nextInt(100);
            for (int j = 2; j < numeroAleatorio; j++) {
                if (numeroAleatorio % j == 0) {
                    i--;
                    break;
                }
                else if (j == (numeroAleatorio -1)) {
                    numeros[i] = numeroAleatorio;
                }
            }
        }
        Arrays.sort(numeros);
        System.out.print(Arrays.toString(numeros));

    }
}
