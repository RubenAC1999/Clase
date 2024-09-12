package Instituto;

public class Main {
    public static void main(String[] args) {
        Profesor p1 = new Profesor("Pepe", 28, true, "filosofia");
        Alumno a1 = new Alumno("alumno1", 16, false, 7);
        Alumno a2 = new Alumno("alumno2", 17, true, 9);
        Alumno a3 = new Alumno("alumno3", 17, true, 9);
        Alumno a4 = new Alumno("alumno4", 17, true, 9);
        Alumno a5 = new Alumno("alumno5", 17, true, 9);
        Alumno a6 = new Alumno("alumno6", 17, true, 9);

        Aula aula1 = new Aula("1234", "filosofia", 10);

        aula1.getListaAlumnos().add(a1);
        aula1.getListaAlumnos().add(a2);
        aula1.getListaAlumnos().add(a3);
        aula1.getListaAlumnos().add(a4);
        aula1.getListaAlumnos().add(a5);
        aula1.getListaAlumnos().add(a6);

        aula1.puedeDarClase(p1);

    }
}
