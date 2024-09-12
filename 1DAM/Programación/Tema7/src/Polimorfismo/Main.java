package Polimorfismo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base;
        double altura;

        System.out.println("Introduzca que figura quiere dibujar (triangulo / rectangulo");
        String respuesta = scanner.nextLine();

        System.out.println("Introduzca la base: ");
        base = scanner.nextDouble();

        System.out.println("Introduzca la altura: ");
        altura = scanner.nextDouble();

        if (respuesta.toLowerCase().equals("triangulo")) {
            Triangulo t1 = new Triangulo (base, altura);
            t1.pintar(t1);
        }

        if (respuesta.toLowerCase().equals("rectangulo")) {
            Rectangulo r1 = new Rectangulo (base, altura);
            r1.pintar(r1);
        }

    }
}
