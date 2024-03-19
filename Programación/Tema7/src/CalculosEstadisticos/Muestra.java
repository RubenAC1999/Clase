package CalculosEstadisticos;

import java.util.Arrays;
public class Muestra {
        private int tamanhoArray;
        private int[] arrayNumeros;

        private final int DEFAULT_SIZE = 10;

        public Muestra(){
            int[] array = new int[DEFAULT_SIZE];

        }

        public Muestra(int tamanhoArray) {
            this.tamanhoArray = tamanhoArray;
        }

        public Muestra(int[] arrayNumeros) {
            int[] copiaArray =
        }

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    public int getTamanhoArray() {
        return tamanhoArray;
    }

    public int[] getArrayNumeros() {
        return arrayNumeros;
    }

    public void setTamanhoArray(int tamanhoArray) {
        this.tamanhoArray = tamanhoArray;
    }

    public void setArrayNumeros(int[] arrayNumeros) {
        this.arrayNumeros = arrayNumeros;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

