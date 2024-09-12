package RubenUD5;

import java.io.*;
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Introduzca un archivo binario");
        String archivoBinario = scanner.nextLine();

        int bytes;
        int contador = 0;

        try {
            FileInputStream archivoEntrada = new FileInputStream(archivoBinario);
            System.out.println("Contenido del archivo en formato hexadecimal: \n");
            while ((bytes = archivoEntrada.read()) != -1) {
                System.out.print(Integer.toHexString(bytes).toUpperCase() + " ");
                contador++;
            }
            archivoEntrada.close();

            System.out.println("\nCantidad total de bytes leidos: " + contador);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
