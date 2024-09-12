package TareasRepaso;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la cantidad de números que desea ingresar: ");
        int cantidad = scanner.nextInt();

        int[] listaNumeros = new int[cantidad];

        System.out.println("Introduzca los números a continuación: ");

        for (int i = 0 ; i < cantidad; i++) {
            System.out.print("\n: ");
            int numero = scanner.nextInt();
            listaNumeros[i] = numero;
        }

        int indice = 1;

        int[] listaNumerosInvertida = new int[listaNumeros.length];

        for (int i = 0; i < listaNumerosInvertida.length; i++) {
            listaNumerosInvertida[listaNumerosInvertida.length - indice] = listaNumeros[i];
            indice++;

        }

        System.out.println("Array original: ");

        indice = 1;
       for (int n : listaNumeros) {
           System.out.println(indice + "º posicion: " + n);
           indice++;
       }

       System.out.println("Array invertido: ");
       indice = 1;
       for (int n : listaNumerosInvertida) {
           System.out.println(indice + "º posición: " + n);
           indice++;
       }



    }
}
