package Instituto;

import java.util.Random;
public class Alumno extends Persona {
    private float nota;

    public Alumno(String nombre, int edad, boolean sexo, float nota) {
        super(nombre, edad, sexo);
        this.nota = nota;
    }

    @Override
    public boolean disponibilidad() {
        int probabilidad = new Random().nextInt(0, 101);
        if (probabilidad >= 50) {
            return true;
        }
        else {
            return false;
        }
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nota=" + nota +
                '}';
    }
}
