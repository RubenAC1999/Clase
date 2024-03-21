package CalculosEstadisticos;

import java.util.Arrays;

public class Estadistica {
    public static void main(String[] args) {
        int[] listaNumeros = {2, 3, 4, 2, 2, 4,};

        Muestra muestraPorDefecto = new Muestra();
        Muestra muestraConstr1 = new Muestra(4);
        Muestra muestraConstr2 = new Muestra(listaNumeros);

        muestraPorDefecto.anhadirNumero(3);
        muestraPorDefecto.anhadirNumero(5);
        muestraPorDefecto.getTamanhoArray();

        muestraConstr2.anhadirNumero(5);

        muestraPorDefecto.getArrayNumeros();
        muestraConstr1.getArrayNumeros();
        muestraConstr2.getArrayNumeros();

        int acumulador = 0;
        for (int numero : muestraConstr2.getArrayNumeros()) {
            acumulador += numero;
        }
        float media = (float) acumulador / muestraConstr2.getTamanhoArray();
        System.out.println("La media de la muestra 3 es " + media);

        int[] arrayNumeros = Arrays.copyOf(muestraConstr2.getArrayNumeros(), muestraConstr2.getTamanhoArray());
        int contador = 0;
        acumulador = 0;
        int numeroMasRepetido = 0;
        for (int i = 0; i < muestraConstr2.getTamanhoArray(); i++) {
            contador = 0;
            for (int j = 0; j < muestraConstr2.getTamanhoArray(); j++){
                if (arrayNumeros[i] == arrayNumeros[j]) {
                    contador++;

                }
            }

            if (contador > acumulador) {
                acumulador = contador;
                numeroMasRepetido = arrayNumeros[i];
            }
        }

        System.out.println("El número más repetido es: " + numeroMasRepetido);



    }
}
