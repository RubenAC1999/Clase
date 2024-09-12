package TareasRepaso;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca un número: ");
        int numero = scanner.nextInt();

        String numeroStr = Integer.toString(numero);

        char[] numerosChar = numeroStr.toCharArray();
        char[] numerosCharInvertida = Arrays.copyOf(numerosChar, numerosChar.length);

        int indice = 1;
        for (int i = 0; i < numerosChar.length; i++) {
            numerosCharInvertida[i] = numerosChar[numerosChar.length - indice];
            indice++;
        }

        String respuesta = Arrays.equals(numerosChar, numerosCharInvertida) ? numero + " es capicúa" : numero +
                " no es capicúa";

        System.out.println(respuesta);
    }
}
