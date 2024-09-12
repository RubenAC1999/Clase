package EjerciciosRepaso;

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            FileReader archivoEntrada = new FileReader("lineas.txt");
            BufferedReader bufferReader = new BufferedReader(archivoEntrada);

            FileWriter archivoSalida = new FileWriter("lineasFiltradas.txt");
            BufferedWriter bufferWriter = new BufferedWriter(archivoSalida);

           String linea;

            while ((linea = bufferReader.readLine()) != null) {

                if (linea.startsWith("Un")) {
                    bufferWriter.write(linea + "\n");
                }

            }

            bufferReader.close();
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
