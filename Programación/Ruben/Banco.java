package Ruben;

import java.util.Arrays;

public class Banco {
    private static CuentaBancaria[] cuentas;
    private final int capacidadCuentas = 100;

    public Banco() {
        cuentas = new CuentaBancaria[capacidadCuentas];
    }

    public static boolean abrirCuenta(CuentaBancaria c) {
        for (CuentaBancaria cuenta : cuentas) {
            if(cuenta == null) {
                cuenta = c;
                return true;
            }
        }
        return false;
    }

    public String listadoCuentas() {
        int contador = 0;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null) {
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

    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equalsIgnoreCase(iban)){
               return cuenta.devolverInfoString();
            }
        }

        return null;
    }

    public boolean ingresoCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equalsIgnoreCase(iban)) {
                cuenta.setSaldo(cuenta.getSaldo() + cantidad);
                return true;
            }
        }

        return false;
    }

    public boolean retiradaCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equalsIgnoreCase(iban)) {
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
                return true;
            }
        }

        return false;
    }

    public double obtenerSaldo(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equalsIgnoreCase(iban)) {
                return cuenta.getSaldo();
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
