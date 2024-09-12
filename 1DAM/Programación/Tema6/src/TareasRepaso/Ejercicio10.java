package TareasRepaso;

import java.util.Random;
import java.util.Arrays;

public class Ejercicio10 {
    public static void main(String[] args) {

        String[] nombres = {"Alumno 1", "Alumno 2", "Alumno 3", "Alumno 4", "Alumno 5"};
        Random aleatorio = new Random();
        int[] numeros = new int[nombres.length];
        Arrays.fill(numeros, -1);
        String[] listaAleatoria = new String[nombres.length];
        System.out.println(nombres.length);

        for (int i = 0; i < nombres.length; i++) {
            int numero = aleatorio.nextInt(nombres.length);
            int indice = 0;
            for (int j : numeros) {
                if (j == numero) {
                    i--;
                    break;
                }
                else if (indice == numeros.length - 1) {
                    numeros[i] = numero;
                    listaAleatoria[i] = nombres[numero];
                }
                indice++;
            }
        }
        System.out.println(Arrays.toString(listaAleatoria));

    }
}
