package TareasRepaso;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduzca el número de comensales: ");
        int numComensales = scanner.nextInt();

       if (numComensales < 1 | numComensales > 5) {
            System.out.println("No hay mesa para " + numComensales + " comensales.");
            System.exit(0);
        }

        System.out.println("Elija el menú para los diferentes comensales");
        System.out.println("--------------------------------------------");

        String[] listaMenus = {"Menú 1", "Menú 2", "Menú 3"};
        String[] pedido = new String[numComensales];

        for (int i = 0; i < numComensales; i++) {
            System.out.print("\nComensal " + (i + 1) + ": ");
            int numMenu = scanner.nextInt();

            if (numMenu < 1 | numMenu > 3) {
                System.out.println("No hay ese número de menú (1 - 3)");
                i--;
                continue;
            }

            pedido[i] = listaMenus[numMenu - 1];
        }
        System.out.println("--------------------------------------------");

        System.out.println("          +-----------+");
        System.out.println("          |   Pedido  |");
        System.out.println("+-------------------------------+");

        for (int i = 0; i < pedido.length; i++) {
            System.out.println("| Comensal " + (i + 1) + ": " + pedido[i] + "            |");
        }

        System.out.println("+-------------------------------+");


    }
}
