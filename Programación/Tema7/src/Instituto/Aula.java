package Instituto;

import java.util.ArrayList;

public class Aula {
    private String id;
    private String materia;

    private int numMaxEstudiantes;

    private ArrayList<Alumno> listaAlumnos;

    public Aula(String id, String materia, int numMaxEstudiantes) {
        this.id = id;
        this.materia = materia;
        this.numMaxEstudiantes = numMaxEstudiantes;
        listaAlumnos = new ArrayList<Alumno>();
    }

    public boolean puedeDarClase(Profesor p) {
        if (!p.getMateria().toLowerCase().equals(getMateria())) {
            System.out.println("El profesor no se corresponde con la materia del aula.");
            return false;
        }
        else if (!p.disponibilidad()) {
            System.out.println("El profesor no ha asistido hoy al instituto.");
            return false;
        }
        else if (numeroAlumnosDisponibles() < (numMaxEstudiantes / 2)) {
            System.out.println("Cantidad de alumnos insuficientes.");
            return false;
        }
        else {
            System.out.println("Se puede dar clase");
            System.out.println("Alumnos aprobados");
            System.out.println("--------------------");
            for (Alumno alumno : listaAlumnos) {
                if (alumno.getNota() >= 5) {
                    System.out.println(alumno.toString());
                }
            }
        return true;
        }

    }


    public int numeroAlumnosDisponibles() {
        int numeroAlumnosDisponibles = 0;
        for (Alumno alumno : listaAlumnos) {
            if (alumno.disponibilidad()) {
                numeroAlumnosDisponibles++;
            }
        }
        return numeroAlumnosDisponibles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getNumMaxEstudiantes() {
        return numMaxEstudiantes;
    }

    public void setNumMaxEstudiantes(int numMaxEstudiantes) {
        this.numMaxEstudiantes = numMaxEstudiantes;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}
