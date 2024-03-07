package TareasRepaso;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca una cadena para transformar: ");
        String cadena = scanner.nextLine();

        System.out.println("El array es: " + Arrays.toString(cadena.toCharArray()));

    }
}
