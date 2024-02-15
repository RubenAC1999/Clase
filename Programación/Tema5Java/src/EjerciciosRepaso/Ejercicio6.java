package EjerciciosRepaso;

import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) {

        try {
            FileReader archivoEntrada = new FileReader("archivo1.txt");
            BufferedReader bufferReader = new BufferedReader(archivoEntrada);

            FileWriter archivoSalida = new FileWriter("conteo.txt");
            BufferedWriter bufferWriter = new BufferedWriter(archivoSalida);

            int contador = 0;
            int caracter;

            while ((caracter = bufferReader.read()) != -1) {

                if (caracter == 32) {
                    continue;
                }

                contador++;
            }

            bufferReader.close();
            bufferWriter.write("El archivo1 tiene " + contador + " palabras.");
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }





    }
}
