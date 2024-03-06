// Crear array de caracteres en base a un string.

package TareasRepaso;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una cadena: ");
        String cadena = scanner.nextLine();

        char[] caracterArray = new char[cadena.length()];


        for (int i = 0; i < cadena.length(); i++) {
            caracterArray[i] = cadena.charAt(i);
            System.out.print(caracterArray[i]);
        }

        System.out.println("\nLa cadena tiene " + caracterArray.length + " caracteres");
    }
}
