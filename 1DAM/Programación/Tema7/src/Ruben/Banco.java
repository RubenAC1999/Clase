package Ruben;

import java.util.Arrays;

public class Banco {
    private static CuentaBancaria[] cuentas;
    private final int capacidadCuentas = 100;

    public Banco() {
        cuentas = new CuentaBancaria[capacidadCuentas];
    }

    public static boolean abrirCuenta(CuentaBancaria c) {
        for (int i = 0; i < cuentas.length; i++) {
            if(cuentas[i] == null) {
                cuentas[i] = c;
                return true;
            }
        }
        return false;
    }

    public static String listadoCuentas() {
        int contador = 0;
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                contador++;
            }
            else {
                break;
            }
        }
        String[] listaCuentas = new String[contador];
        for (int i = 0; i < contador; i++) {
            listaCuentas[i] = cuentas[i].devolverInfoString();
        }
        return Arrays.toString(listaCuentas);
    }

    public static String informacionCuenta(String iban) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getIban().equalsIgnoreCase(iban)){
               return cuentas[i].devolverInfoString();
            }
        }

        return null;
    }

    public static boolean ingresoCuenta(String iban, double cantidad) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getIban().equalsIgnoreCase(iban)){
                cuentas[i].setSaldo(cuentas[i].getSaldo() + cantidad);
                return true;
            }
        }

        return false;
    }

    public static boolean retiradaCuenta(String iban, double cantidad) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getIban().equalsIgnoreCase(iban)){
                cuentas[i].setSaldo(cuentas[i].getSaldo() - cantidad);
                return true;
            }
        }

        return false;
    }

    public static double obtenerSaldo(String iban) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getIban().equalsIgnoreCase(iban)){
                return cuentas[i].getSaldo();
            }
        }

        return -1;
    }


    // GETTERS Y SETTERS //
    public CuentaBancaria[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(CuentaBancaria[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getCapacidadCuentas() {
        return capacidadCuentas;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "cuentas=" + Arrays.toString(cuentas) +
                ", capacidadCuentas=" + capacidadCuentas +
                '}';
    }
}
