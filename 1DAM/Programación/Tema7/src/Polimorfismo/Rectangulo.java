package Polimorfismo;

public class Rectangulo extends FiguraGeometrica{
    private double base;
    private double altura;
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public void pintar(FiguraGeometrica a) {
        for (int i = 1; i <= getAltura(); i++) {
            if ((i == 1) || (i == getAltura())){
                System.out.println();
                for (int j = 1; j <= getBase(); j++) {
                    System.out.print("*");
                }
            }
            else {
                System.out.print("*");
            }
        }
    }
}
