package EcuacionSegundoGrado;

public class Raices {
    double a;
    double b;
    double c;

    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return Math.pow(getB(), 2) - (4 * getA() * getC());
    }
    public String obtenerRaices() {
        double solucion1 = (-getB() + Math.sqrt(getDiscriminante())) / (2 * getA());
        double solucion2 = (-getB() - Math.sqrt(getDiscriminante())) / (2 * getA());

        return "Tiene dos soluciones: \nSolución 1: " + solucion1 + "\nSolución 2: " + solucion2;
    }

    public String obtenerRaiz() {
        double solucion = (-getB() + Math.sqrt(getDiscriminante())) / (2 * getA());
        return "Tiene una única solución: \nSolución: " + solucion;
    }

    public boolean tieneRaices() {
        return getDiscriminante() > 0;
    }

    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    public String calcular() {
        if (tieneRaices()) {
            return obtenerRaices();
        }
        else if (tieneRaiz()) {
            return obtenerRaiz();
        }
        else {
            return "No tiene solución.";
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
