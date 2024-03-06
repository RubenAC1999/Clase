package TareasRepaso;

public class Ejercicio8 {
    public static void main(String[] args) {

        int[][] matriz = new int[10][10];

        for (int i = 0; i < matriz.length; i++) {
            System.out.println();

            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                }

                System.out.print(matriz[i][j] + " ");
            }
        }
    }
}
