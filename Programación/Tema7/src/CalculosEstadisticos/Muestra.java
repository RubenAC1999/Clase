package CalculosEstadisticos;

import java.util.Arrays;
public class Muestra {
        private int tamanhoArray;
        private int[] arrayNumeros;

        private final int DEFAULT_SIZE = 10;

        public Muestra(){
            this.arrayNumeros = new int[DEFAULT_SIZE];
        }

        public Muestra(int tamanhoArray) {
            this.tamanhoArray = tamanhoArray;
            this.arrayNumeros = new int[tamanhoArray];
        }

        public Muestra(int[] arrayNumeros) {
            this.arrayNumeros = arrayNumeros.clone();
        }


    public int getTamanhoArray() {
        tamanhoArray = 0;
        for (int i = 0 ; i < arrayNumeros.length; i++) {
            if (arrayNumeros[i] != 0) {
                tamanhoArray++;
            }
        }
        return tamanhoArray;
    }

    public int[] getArrayNumeros() {
            System.out.println("Los números actuales del array son:");
            int indice = 0;
            int[] arrayNumerosCopia = new int[getTamanhoArray()];
            for (int i = 0; i < arrayNumeros.length; i++) {
                if (arrayNumeros[i] != 0) {
                   arrayNumerosCopia[indice] = arrayNumeros[i];
                   indice++;
                }
            }
            System.out.println(Arrays.toString(arrayNumerosCopia));
            return arrayNumerosCopia;
    }


    public void anhadirNumero(int numero) {
        Arrays.sort(arrayNumeros);
        try {
            for (int i = 0; i < arrayNumeros.length; i++) {
                if (arrayNumeros[i] != 0) {
                    i--;
                    arrayNumeros[i] = numero;
                    break;
                } else if (i == (arrayNumeros.length - 1)) {
                    arrayNumeros[i] = numero;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No se pueden añadir más números al array");
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

