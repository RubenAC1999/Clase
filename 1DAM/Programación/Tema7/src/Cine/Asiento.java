package Cine;

public class Asiento {
    private char letra;
    private int fila;
    private Espectador espectador;

    public Asiento(int fila, char letra) {
        this.letra = letra;
        this.fila = fila;
    }



    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        String numeroFila = String.valueOf(getFila());
        return numeroFila + getLetra();
    }
}
