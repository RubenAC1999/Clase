package EjerciciosRepaso;

import java.io.FileReader;
import java.io.IOException;

public class EjercicioD1 {
    public static void main(String[] args) {

        try {
            FileReader archivo = new FileReader("archivo1.txt");

            int caracter;

            while ((caracter = archivo.read()) != -1) {
                System.out.print((char) caracter);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
