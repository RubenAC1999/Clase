package Tareas;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca la cantidad de productos que desee registrar");
        int cantidadRegistro = scanner.nextInt();

        String[] productos = new String[cantidadRegistro];
        int[] cantidadUnidades = new int[cantidadRegistro];
        float[] precioUnidad = new float[cantidadRegistro];
        float[] totalProducto = new float[cantidadRegistro];

        float acumulador = 0;

        for (int i = 0; i < cantidadRegistro; i++) {
            scanner.nextLine();
            System.out.println("-------------- " + (i + 1) + "º PRODUCTO --------------");
            System.out.println("Introduzca el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            productos[i] = nombreProducto;

            System.out.println("Introduzca la cantidad de unidades: ");
            int cantidad = scanner.nextInt();
            cantidadUnidades[i] = cantidad;

            System.out.println("Introduzca el precio por unidad: ");
            float precio = scanner.nextFloat();
            precioUnidad[i] = precio;

            totalProducto[i] = cantidadUnidades[i] * precioUnidad[i];

            acumulador += totalProducto[i];
        }

        System.out.println("--------------------------------------");
        System.out.println("RESUMEN DE LA VENTA");
        System.out.println("--------------------------------------");
        System.out.println("Producto\t\t\tCantidad\t\tPrecio por unidad\t\tTotal");
        System.out.println("--------------------------------------");
        for (int i = 0; i < cantidadRegistro; i++) {
            System.out.printf("%-19s %-16d$%-23.2f$%-9.2f\n", productos[i], cantidadUnidades[i], precioUnidad[i], totalProducto[i]);
        }
        System.out.println("--------------------------------------");
        System.out.printf("Total de la Venta: $%.2f", acumulador);
    }
}
