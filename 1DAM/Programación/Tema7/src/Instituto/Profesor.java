package Instituto;
import java.util.Random;
public class Profesor extends Persona{
    private String materia;

    public Profesor(String nombre, int edad, boolean sexo, String materia) {
        super(nombre, edad, sexo);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public boolean disponibilidad() {
        int probabilidad = new Random().nextInt(0, 101);
        if (probabilidad >= 20) {
            return true;
        }
        else {
            return false;
        }
    }
}
