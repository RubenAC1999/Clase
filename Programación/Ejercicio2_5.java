package Rubent03;

import java.util.Scanner;
public class Ejercicio2_5 {
    public static void main(String[] args) {
        double num;
        double acumulador = 0;
        String numString;
        double numeroMayor = 0;
        double numeroMenor = 0;
        double numeroPasado = 0;


        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca un número (00 para finalizar): ");
        numString = entrada.nextLine();
        num = Double.parseDouble(numString);

        numeroMayor = num;
        numeroMenor = num;

        do {
            if(!numString.equals("00")) {
                acumulador += num;

                if(num >= numeroPasado && num >= numeroMayor) {
                    numeroMayor = num;
                }

                if(num < numeroPasado && num < numeroMenor || numeroMenor == 0) {
                    numeroMenor = num;
                }

                numeroPasado = num;

                System.out.println("Introduce otro número ");
                numString = entrada.nextLine();
                num = Double.parseDouble(numString);
            }
        }while(!numString.equals("00"));

        System.out.println("La suma de los números es: " + acumulador);
        System.out.println("El número mayor es: " + numeroMayor);
        System.out.println("El número menor es: " + numeroMenor);

    }
}
