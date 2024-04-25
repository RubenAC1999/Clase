package Ruben;

import Ruben.CuentaCorriente;
import Ruben.Persona;

public class CuentaCorrientePersonal extends CuentaCorriente {
    private int comisionMantenimientoAnual;

    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, String listaEntidades,
                                   int comisionMantenimientoAnual) {
        super(titular, saldo, iban, listaEntidades);
        this.comisionMantenimientoAnual = comisionMantenimientoAnual;
    }

    public int getComisionMantenimientoAnual() {
        return comisionMantenimientoAnual;
    }

    public void setComisionMantenimientoAnual(int comisionMantenimientoAnual) {
        this.comisionMantenimientoAnual = comisionMantenimientoAnual;
    }

    @Override
    public String toString() {
        return "CuentaCorrientePersonal{" +
                "comisionMantenimientoAnual=" + comisionMantenimientoAnual +
                '}';
    }

    @Override
    public String devolverInfoString() {
        return "Titular: " + getTitular() + "\nTipo de Cuenta: Cuenta corriente personal" + "\nSaldo: " + getSaldo() +
                "\nIBAN: " + getIban() + "\nLista de entidades: " + getListaEntidades() +
                "\nComisión de mantenimiento anual: " + getComisionMantenimientoAnual();
    }

}
