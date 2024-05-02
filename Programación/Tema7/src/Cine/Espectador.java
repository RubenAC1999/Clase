package Cine;

import java.util.Random;
public class Espectador {
    private String nombre;
    private int edad;
    private float dinero;

    private final String[] LISTA_NOMBRES = {"Rubén", "Pablo", "Oscar", "Simón", "Alberto", "Andrés"};

    public Espectador() {
        Random random = new Random();

        nombre = LISTA_NOMBRES[random.nextInt(0,6)];
        edad = random.nextInt(3, 60);
        dinero = random.nextFloat(0,50);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public String[] getLISTA_NOMBRES() {
        return LISTA_NOMBRES;
    }
}
