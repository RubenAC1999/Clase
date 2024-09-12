package Ruben;

import Ruben.CuentaCorriente;
import Ruben.Persona;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    private int tipoInteresDescubierto;
    private int maximoDescubiertoPermitido;

    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, String listaEntidades,
                                  int tipoInteresDescubierto, int maximoDescubiertoPermitido) {
        super(titular, saldo, iban, listaEntidades);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
    }

    public int getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(int tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public int getMaximoDescubiertoPermitido() {
        return maximoDescubiertoPermitido;
    }

    public void setMaximoDescubiertoPermitido(int maximoDescubiertoPermitido) {
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
    }

    @Override
    public String devolverInfoString() {
        return "Titular: " + getTitular() + "\nTipo de Cuenta: Cuenta corriente de empresa" + "\nSaldo: " + getSaldo() +
                "\nIBAN: " + getIban() + "\nLista de entidades: " + getListaEntidades() +
                "\nTipo de interés al descubierto: " + getTipoInteresDescubierto() + "\nMáximo descubierto permitido: "
                + getMaximoDescubiertoPermitido();
    }
}
