package TareasRepaso;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Comprobación de palíndromo");
        System.out.println("---------------------------");
        System.out.println("\nIntroduzca una cadena: ");
        String cadena = scanner.nextLine();

        cadena = cadena.replace(" ", "");

        char[] caracteresCadena = new char[cadena.length()];
        char[] caracteresCadenaInvertido = new char[cadena.length()];

        int indice = 1;

        for (int i = 0; i < cadena.length(); i++) {
            caracteresCadena[i] = cadena.toLowerCase().charAt(i);
            caracteresCadenaInvertido[cadena.length() - indice] = caracteresCadena[i];
            indice++;
        }

        String respuesta = Arrays.equals(caracteresCadena, caracteresCadenaInvertido) ? " Es un palíndromo" :
                "No es un palíndromo";

        System.out.println(respuesta);

    }
}
