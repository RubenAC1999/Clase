package Ruben;

import Ruben.Persona;

public abstract class CuentaBancaria implements Imprimible {
    private Persona titular;
    private double saldo;
    private String iban;

    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular=" + titular +
                ", saldo=" + saldo +
                ", iban='" + iban + '\'' +
                '}';
    }




}
