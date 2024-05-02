package Cine;

import java.util.Random;
public class Pelicula {
    private String titulo;
    private int duracion;
    private int edadMin;
    private String director;

    private final String[] NOMBRES_DIRECTORES = {"Rubén", "Pablo", "Oscar", "Simón", "Alberto", "Andrés"};
    private final String[] LISTA_PELICULAS = {"Kill Bill", "Interstellar", "El padrino", "Peppa pig", "El viaje de Chihiro"};
    private final int[] EDADES = {0, 3, 7, 13, 16, 18};

    public Pelicula() {
        Random random = new Random();
        titulo = LISTA_PELICULAS[random.nextInt(0,5)];
        director = NOMBRES_DIRECTORES[random.nextInt(0,6)];
        edadMin = EDADES[random.nextInt(0,6)];
        duracion = random.nextInt(0,301);
    }

    public Pelicula(String titulo, int duracion, int edadMin, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMin = edadMin;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", edadMin=" + edadMin +
                ", director='" + director + '\'' +
                '}';
    }
}
