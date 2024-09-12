package EjerciciosRepaso;

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {

        try {
            FileInputStream archivo1 = new FileInputStream("archivo1.txt");
            FileInputStream archivo2 = new FileInputStream("archivo2.txt");
            BufferedInputStream bufferReader1 = new BufferedInputStream(archivo1);
            BufferedInputStream bufferReader2 = new BufferedInputStream(archivo2);
            FileOutputStream archivoCombinado = new FileOutputStream("archivo_combinado.txt");

            int bytes;

            while ((bytes = bufferReader1.read()) != -1) {
                archivoCombinado.write(bytes);
            }

            bufferReader1.close();

            String mensaje = "\n==== Separador entre archivos ====\n";
            archivoCombinado.write(mensaje.getBytes());

            while ((bytes = bufferReader2.read()) != -1) {
                archivoCombinado.write(bytes);
            }

            bufferReader2.close();
            archivoCombinado.close();

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
