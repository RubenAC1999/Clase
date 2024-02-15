// Recepción y escritura de datos utilizando cuadros JOptionPane.

package EjerciciosRepaso;

import javax.swing.JOptionPane;
import java.io.FileWriter;

public class Ejercicio1 {
    public static void main(String[] args) {

        try {
            FileWriter archivoDatos = new FileWriter("datos_vehiculo.txt",
                    true);

            JOptionPane.showMessageDialog(null, "Archivo localizado correctamente");

            archivoDatos.write("\n--------------------------------");
            String respuesta =  JOptionPane.showInputDialog("Introduzca la matrícula");
            archivoDatos.write("\nMatricula: " + respuesta);

            respuesta = JOptionPane.showInputDialog("Introduzca la marca del vehículo: ");
            archivoDatos.write("\nMarca: " + respuesta);

            respuesta = JOptionPane.showInputDialog("Introduzca el tamaño del depósito (en litros): ");
            archivoDatos.write("\nTamaño del depósito: " + respuesta + " litros");

            respuesta = JOptionPane.showInputDialog("Introduzca el modelo del vehículo: ");
            archivoDatos.write("\nModelo: " + respuesta);
            archivoDatos.write("\n--------------------------------");

            JOptionPane.showMessageDialog(null, "Datos introducidos!");
            archivoDatos.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }




}
