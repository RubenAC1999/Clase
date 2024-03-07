package TareasRepaso;

import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int DIVISOR=23;
        char letrasNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
                'H', 'L', 'C', 'K', 'E'};

        System.out.println("Introduzca los números de su dni: ");
        int dni = scanner.nextInt();

        int resto = dni % DIVISOR;

        char letra=letrasNIF[resto];

        System.out.println("Tu DNI es " +dni+letra);

    }
}