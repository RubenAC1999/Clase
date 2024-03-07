package TareasRepaso;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Indique el tamaño del array: ");
        int capacidad = scanner.nextInt();

        int[] numeros = new int[capacidad];
        int[] numerosFiltrados = new int[capacidad];

        System.out.print("\nNumeros generados: ");
        for (int i = 0; i < numeros.length; i++) {
            int numeroAleatorio = random.nextInt(300);
            numeros[i] = numeroAleatorio;
            System.out.print(numeros[i] + ", ");
        }

        System.out.println("\nIndique el número del dígito final: ");
        int digito = scanner.nextInt();

        String digitoStr = Integer.toString(digito);
        digitoStr = String.valueOf(digitoStr.charAt(digitoStr.length()- 1));


        int contador = 0;
        int indice = 0;
        for (int n : numeros) {
            String nStr = Integer.toString(n);
            nStr = String.valueOf(nStr.charAt(nStr.length() - 1));
            if (nStr.equals(digitoStr)) {
                numerosFiltrados[indice] = n;
                contador++;
                indice++;
            }
        }

        System.out.print("\nLos números acabados en " + digito + " son: ");

        for (int i = 0; i < contador; i++) {
            System.out.print(numerosFiltrados[i] + ", ");
        }




    }
}
