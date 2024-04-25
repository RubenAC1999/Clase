package Ruben;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;

        System.out.println("        Menú Banco      ");
        System.out.println("-------------------------");
        System.out.println("Seleccione una opción a realizar: ");
        System.out.println("1. Abrir una cuenta nueva");
        System.out.println("2. Ver lista de cuentas");
        System.out.println("3. Obtener datos de una cuenta");
        System.out.println("4. Realizar ingreso");
        System.out.println("5. Realizar efectivo");
        System.out.println("6. Consultar saldo");
        System.out.println("7. Finalizar programa");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch(opcion) {
            case 1:
                System.out.println("Abrir una cuenta nueva");
                Persona p1 = new Persona();

                System.out.println("-------------------");
                System.out.println("Datos del titular");
                System.out.println("-------------------");
                System.out.println("Nombre: ");
                p1.setNombre(scanner.nextLine());

                System.out.println("Apellidos: ");
                p1.setApellidos(scanner.nextLine());

                System.out.println("DNI: ");
                p1.setDni(scanner.nextLine());

                System.out.println("-------------------");
                System.out.println("Datos de la cuenta");
                System.out.println("-------------------");

                System.out.println("Introduzca el saldo inicial para la cuenta: ");
                double saldo = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Introduzca el IBAN de la cuenta: ");
                String iban = scanner.nextLine();

                System.out.println("Seleccione el tipo de cuenta a crear (ahorro / corriente)");
                String tipoCuenta = scanner.nextLine();

                if (tipoCuenta.equalsIgnoreCase("ahorro")) {
                    System.out.println("Indique el tipo de interés anual: ");
                    int tipoInteres = scanner.nextInt();
                    scanner.nextLine();

                    CuentaAhorro c1 = new CuentaAhorro(p1, saldo, iban, tipoInteres);
                    System.out.println(Banco.abrirCuenta(c1));
                }

                if (tipoCuenta.equalsIgnoreCase("corriente")) {
                    System.out.println("Indique el tipo de cuenta corriente a crear (personal / empresa)");
                    tipoCuenta = scanner.nextLine();


                }






        }



    }
}
