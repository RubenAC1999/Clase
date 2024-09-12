package Ruben;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco1 = new Banco();
        int opcion;

        int contador = 0;

        do {
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
        opcion = scanner.nextInt();
        scanner.nextLine();


            switch (opcion) {
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
                        System.out.println(Arrays.toString(banco1.getCuentas()));
                    }

                    if (tipoCuenta.equalsIgnoreCase("corriente")) {
                        System.out.println("Indique el tipo de cuenta corriente a crear (personal / empresa)");
                        tipoCuenta = scanner.nextLine();

                        System.out.println("Indique la lista de entidades permitida: ");
                        String listaEntidades = scanner.nextLine();

                        if (tipoCuenta.equalsIgnoreCase("personal")) {
                            System.out.println("Introduzca la comisión de mantenimiento: ");
                            int comisionMantenimiento = scanner.nextInt();

                            CuentaCorrientePersonal ccp1 = new CuentaCorrientePersonal(p1, saldo, iban,
                                    listaEntidades, comisionMantenimiento);
                            System.out.println(Banco.abrirCuenta(ccp1));
                        } else if (tipoCuenta.equalsIgnoreCase("empresa")) {
                            System.out.println("Introduzca el tipo de interés por descubierto: ");
                            int tipoInteresDesc = scanner.nextInt();

                            System.out.println("Introduzca el máximo descubierto permitido: ");
                            int maximoDescubierto = scanner.nextInt();

                            CuentaCorrienteEmpresa cce1 = new CuentaCorrienteEmpresa(p1, saldo, iban,
                                    listaEntidades, tipoInteresDesc, maximoDescubierto);
                            System.out.println(Banco.abrirCuenta(cce1));
                        }
                    }

                    break;

                case 2:
                    System.out.println(Banco.listadoCuentas());
                    break;

                case 3:
                    System.out.println("Introduzca el IBAN de la cuenta a buscar: ");
                    System.out.println(Banco.informacionCuenta(scanner.nextLine()));
                    break;

                case 4:
                    System.out.println("Introduzca el IBAN de la cuenta: ");
                    iban = scanner.nextLine();

                    System.out.println("Introduzca la cantidad a ingresar: ");
                    double cantidad = scanner.nextDouble();

                    System.out.println(Banco.ingresoCuenta(iban, cantidad));
                    break;

                case 5:
                    System.out.println("Introduzca el IBAN de la cuenta: ");
                    iban = scanner.nextLine();

                    System.out.println("Introduzca la cantidad a ingresar: ");
                    cantidad = scanner.nextDouble();

                    System.out.println(Banco.retiradaCuenta(iban, cantidad));
                    break;

                case 6:
                    System.out.println("Introduzca el IBAN de la cuenta: ");
                    System.out.println(Banco.obtenerSaldo(scanner.nextLine()));
                    break;

                case 7:
                    System.exit(0);

            }
        } while (opcion != 7);



    }
}
