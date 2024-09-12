package RubenUD5;

import java.io.*;
public class Ejercicio1 {
    public static void main(String[] args) {
        try {

            FileReader archivoEntrada = new FileReader("entrada.txt");
            StreamTokenizer sTokenizer = new StreamTokenizer(archivoEntrada);

            FileWriter archivoSalida = new FileWriter("salida.txt");
            BufferedWriter bufferWriter = new BufferedWriter(archivoSalida);

            double acumulador = 0;
            int contador = 0;


            while ((sTokenizer.nextToken()) != sTokenizer.TT_EOF) {

                if (sTokenizer.ttype == sTokenizer.TT_NUMBER) {
                    acumulador += sTokenizer.nval;
                    contador++;
                }
            }

            System.out.println("La suma total de los números es de: " + acumulador);
            System.out.println("Hay " + contador + " numeros en el archivo.");


            archivoEntrada.close();
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
