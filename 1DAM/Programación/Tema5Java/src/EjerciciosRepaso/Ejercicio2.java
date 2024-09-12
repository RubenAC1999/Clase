package EjerciciosRepaso;

import java.util.*;
import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            FileOutputStream streamSalida = new FileOutputStream("lista_numeros.txt", true);

            System.out.print("Introduzca la cantidad de números aleatorios que desee generar: ");
            int cantidad = scanner.nextInt();

            Random numerosAleatorios = new Random();

            System.out.println("Nuevos números añadidos al archivo: ");

            for (int i = 0; i < cantidad; i++) {
                int numero = numerosAleatorios.nextInt(100);
                System.out.println(numero);
                streamSalida.write(numero);
            }

            System.out.println("Contenido completo del archivo: ");
            FileInputStream streamEntrada = new FileInputStream("lista_numeros.txt");

            while (true) {
                int posicion = streamEntrada.read();

                if (posicion < 0) {
                    break;
                }

                System.out.println(posicion);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }


        }


    }

