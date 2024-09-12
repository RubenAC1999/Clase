package EjerciciosRepaso;

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) {

        try {
            FileReader archivoSalida = new FileReader("enteros.txt");
            StreamTokenizer sTokenizer = new StreamTokenizer(archivoSalida);

            int contador = 0;
            int acumulador = 0;

            while ((sTokenizer.nextToken()) != sTokenizer.TT_EOF) {

                if (sTokenizer.ttype == sTokenizer.TT_NUMBER) {
                    contador++;
                    acumulador += sTokenizer.nval;
                }

            }

            archivoSalida.close();
            System.out.println("El archivo tiene " + contador + " números");
            System.out.println("La suma de los números que hay en el archivo es de: " + acumulador);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
