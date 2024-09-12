package RubenUD5;

import java.io.*;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Introduzca el nombre del archivo donde desee buscar: ");
        String archivo = scanner.nextLine();

        System.out.println("Introduzca la cadena que desea buscar");
        String palabra = scanner2.nextLine();


        try {
            FileReader reader = new FileReader(archivo);
            BufferedReader bufferReader = new BufferedReader(reader);



            String linea;
            int contador = 0;

            while ((linea = bufferReader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    contador++;
                }
            }

            System.out.println("Se ha encontrado " + contador + " coincidencias");

            reader.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
