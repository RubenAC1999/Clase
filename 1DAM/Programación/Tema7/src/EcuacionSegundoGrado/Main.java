package EcuacionSegundoGrado;

public class Main {
    public static void main(String[] args) {
        Raices ecuacion = new Raices(1, 4, 4);
        System.out.println(ecuacion.calcular());
    }
}
