package Alumno;

public class AlumnoDatos {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Federico", "García", 17, "fede@gmail.com",
                "982828282");
        Alumno alumno2 = new Alumno("Pepe", "Gutiérrez", 23);

       System.out.println(alumno1);
       System.out.println(alumno2);

       System.out.println(alumno1.getNombre() + " " + alumno1.esMayorEdad());
       System.out.println(alumno2.getNombre() + " " + alumno2.esMayorEdad());
       String respuesta = alumno1.equals(alumno2) ? "Tienen los mismos datos" : "No tienen los mismos datos";
       System.out.println(respuesta);

    }
}
