package TareasRepaso;

public class Ejercicio14 {
    public static void main(String[] args) {
        int[] numeros = new int[100];
        int acumulador = 0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
            System.out.println(i + 1);
            acumulador += i + 1;
        }
        System.out.println("Suma total de los valores: " + acumulador);
        System.out.println("Media total de los valores: " + acumulador / numeros.length);

    }
}
