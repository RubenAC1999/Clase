package Ruben;

import Ruben.Persona;

public class CuentaAhorro extends CuentaBancaria {

    private int tipoInteresAnual;


    public CuentaAhorro(Persona titular, double saldo, String iban, int tipoInteresAnual) {
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    public int getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    public void setTipoInteresAnual(int tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }

    @Override
    public String devolverInfoString() {
        return "Titular: " + getTitular() + "\nTipo de cuenta: Cuenta de Ahorro" + "\nSaldo: " + getSaldo() + "\nIBAN: "
                + getIban() + "\ntipoInteresAnual: " + getTipoInteresAnual();
    }
}
