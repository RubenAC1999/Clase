package RubenUD5;

import java.io.*;
import java.util.Scanner;
public class GestorArchivos {

    public static void main(String[] args) {

        GestorArchivos archivos = new GestorArchivos();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Opciones para ficheros");
        System.out.println("-------------------------");
        System.out.println("1. Leer fichero existente");
        System.out.println("2. Crear nuevo fichero");
        System.out.println("3. Copiar fichero en otro");
        System.out.println("4. Buscar una palabra en el fichero");
        System.out.println("5. Salir del programa");
        System.out.print("\n\nElija una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                try {
                    archivos.leerArchivo();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;

            case 2:
                try {
                    archivos.crearArchivo();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;

            case 3:
                try {
                    archivos.copiarArchivo();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;

            case 4:
                try {
                    archivos.buscarPalabra();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;

            case 5:
                System.exit(0);
        }

    }

    public void leerArchivo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca la ruta o el nombre del archivo que desee leer: ");
        String archivo = scanner.nextLine();

        FileReader reader = new FileReader(archivo);
        int caracter = 0;

        while (caracter != -1) {
            caracter = reader.read();
            System.out.print((char) caracter);
        }

        reader.close();
    }


    public void crearArchivo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del archivo que desea crear: ");
        String archivo = scanner.nextLine();
        File archivoCreado = new File(archivo);

        archivoCreado.createNewFile();

    }

    public void copiarArchivo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduzca el archivo que desee copiar");
        String archivoEntrada = scanner.nextLine();

        System.out.println("Introduzca el archivo de destino de la copia");
        String archivoDestino = scanner2.nextLine();

        FileReader reader = new FileReader(archivoEntrada);
        FileWriter writer = new FileWriter(archivoDestino);

        int posicion;
        while ((posicion = reader.read()) != -1) {

            writer.write((char) posicion);
        }

        reader.close();
        writer.close();
    }


    public void buscarPalabra() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Introduzca el archivo donde desee buscar la palabra: ");
        String archivo = scanner.nextLine();

        FileReader reader = new FileReader(archivo);
        BufferedReader bufferReader = new BufferedReader(reader);

        System.out.println("Introduzca la palabra que desee buscar");
        String palabra = scanner2.nextLine();

        String linea;

        while ((linea = bufferReader.readLine()) != null) {
            if (linea.contains(palabra)) {
                System.out.println(linea);
            }
        }

        bufferReader.close();

    }


}
