// Filtrar lista de números

package TareasRepaso;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] listaValores = {5, 5, 9, 3, 45, 23, 45, 12, 87, 9, 6, 5};

        System.out.println("Introduce el valor que deseas borrar: ");
        int valor = scanner.nextInt();

        System.out.print("Valor a buscar: " + valor);
        System.out.print("\nArray inicial: ");

        for (int i : listaValores) {
            System.out.print(i + " ");
        }

        System.out.println("\nValor borrado: " + valor);

        int contador = 0;
        for (int i : listaValores) {
            if (i == valor) {
                contador++;
            }
        }
        System.out.println("Cantidad de ocurrencias: " + contador);
        int[] listaValoresFiltrada = new int[listaValores.length - contador];
        int posicion = 0;

        System.out.print("\nArray final: ");
        for (int i : listaValores) {
           if (i != valor) {
               listaValoresFiltrada[posicion] = i;
               System.out.print(listaValoresFiltrada[posicion] + " ");
               posicion++;
           }
        }


    }
}
