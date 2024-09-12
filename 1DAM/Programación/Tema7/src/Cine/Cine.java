package Cine;

public class Cine {
    private Asiento asientos[][];
    private double precio;
    private Pelicula pelicula;

    Cine(int filas, int columnas, double precio, Pelicula pelicula) {
        asientos = new Asiento[filas][columnas];
        this.precio = precio;
        this.pelicula = pelicula;
    }

    public void generadorAsientos() {
        for(int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                asientos[i][j] = new Asiento(asientos.length - i, letras.charAt(j));
                System.out.print(asientos[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    public boolean haySitio() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[0].length; j++) {
                if (asientos[i][j].getEspectador() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaOcu(int fila, char columna) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int numeroChar = letras.indexOf(columna);
        if (asientos[fila-1][numeroChar].getEspectador() == null) {
            return false;
        }
        return true;
    }

    public boolean tieneEdad(Asiento a) {
        if (a.getEspectador().getEdad() < pelicula.getEdadMin()) {
            a.setEspectador(null);
            return false;
        }

        return true;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
