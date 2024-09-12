package RubenT05;

import java.io.FileReader;
import java.io.FileWriter;

public class Tarea08 {
    public static void main(String[] args) {

        try {
            FileReader archivo1 = new FileReader("archivo1.txt");
            FileReader archivo2 = new FileReader("archivo2.txt");

            FileWriter archivoCombinado = new FileWriter("archivo_combinado.txt");

            int linea;

            while ((linea = archivo1.read()) != -1) {
                archivoCombinado.write(linea);
            }

            archivo1.close();
            archivoCombinado.write("\n");

            while ((linea = archivo2.read()) != -1) {
                archivoCombinado.write(linea);
            }

            archivo2.close();
            archivoCombinado.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
