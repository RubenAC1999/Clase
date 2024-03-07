package TareasRepaso;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] letras = new char[26];

        int indice = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            letras[indice] = c;
            indice++;
        }

        String cadena = "";
        do {
            System.out.println("Introduzca el número del caracter (-1 para finalizar): ");
            indice = scanner.nextInt();

            if (indice == -1) {
                System.out.println("Finalizando programa...");
            }
            else if (indice >= 0 && indice <= 25) {
                cadena += letras[indice];
            }
            else {
                System.out.println("Error, inserte otro número.");
            }
        } while (indice != -1);

        System.out.println("Cadena realizada: " + cadena);



    }
}
