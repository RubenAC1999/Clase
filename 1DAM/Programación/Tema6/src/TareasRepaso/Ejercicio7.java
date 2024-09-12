package TareasRepaso;

import java.util.Random;
import java.util.Arrays;

public class Ejercicio7 {
    public static void main(String[] args) {

        // Creación de array de letras mayúsculas
        char[] letrasMayusculas = new char[26];
        int posicion = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            letrasMayusculas[posicion] = c;
            posicion++;
        }

        // Creación de array de letras minúsculas
        char[] letrasMinusculas = new char[26];
        posicion = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            letrasMinusculas[posicion] = c;
            posicion++;
        }

        // Creador del 3 array (resultado)
        char[] resultado = new char[26];
        Random indiceAleatorio = new Random();
        for (int i = 0; i < 26; i++) {
            if (i % 2 == 0) {
                resultado[i] = letrasMayusculas[indiceAleatorio.nextInt(0, 25)];
            }
            else {
                resultado[i] = letrasMinusculas[indiceAleatorio.nextInt(0, 25)];
            }
        }

        System.out.println("Array de letras mayúsculas: " + Arrays.toString(letrasMayusculas));
        System.out.println("Array de letras minúsculas: " + Arrays.toString(letrasMinusculas));
        System.out.println("\nArray resultado: " + Arrays.toString(resultado));

    }
}
