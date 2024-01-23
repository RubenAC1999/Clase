public class Ejercicio2_2 {
    public static void main(String[] args) {

        System.out.println("************************");
        System.out.println("* TABLA DE MULTIPLICAR *");
        System.out.println("************************");

        for(int i = 0; i < 11; i++) {
            System.out.println("------------------");
            System.out.println(" TABLA DEL " + i);
            System.out.println("------------------");
            for(int j = 0; j < 11; j++) {
                int multiplicacion = i * j;
                System.out.println(i + " x " + j + " = " + multiplicacion);
            }
        }
    }
}
