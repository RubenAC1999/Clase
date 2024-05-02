package Ruben;

import Ruben.CuentaBancaria;
import Ruben.Persona;

public abstract class CuentaCorriente extends CuentaBancaria {
    private String listaEntidades;

    public CuentaCorriente(Persona titular, double saldo, String iban, String listaEntidades) {
        super(titular, saldo, iban);
        this.listaEntidades = listaEntidades;
    }

    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "listaEntidades='" + listaEntidades + '\'' +
                '}';
    }
}
