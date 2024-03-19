package Alumno;

public class AlumnoArray {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Federico", "García", 59, "fede@gmail.com",
                "982828282");
        Alumno alumno2 = new Alumno("Pepe", "Gutiérrez", 23);
        Alumno alumno3 = new Alumno ("Eustaquio", "Román", 40);
        Alumno alumno4 = new Alumno("Rubén", "Agra", 24);
        Alumno alumno5 = new Alumno("Fernando", "Alonso", 100);

        Alumno[] listaAlumnos = {alumno1, alumno2, alumno3, alumno4, alumno5};
        int comparador = listaAlumnos[0].getEdad();
        String respuesta = "El alumno más joven es " + listaAlumnos[0].getNombre() + " " + listaAlumnos[0].getApellidos()
                + "con " + listaAlumnos[0].getEdad() + " años";

        for (Alumno x : listaAlumnos) {
            if (x.getEdad() < comparador) {
                comparador = x.getEdad();
                respuesta = "El alumno más joven es " + x.getNombre() + " " + x.getApellidos() + " con " +
                        x.getEdad() + " años";
            }
        }

        System.out.println(respuesta);
    }
}
