package Alumno;

import java.util.Objects;

public class Alumno {
   private String nombre;
   private String apellidos;
   private int edad;
   private String email;
   private String telefono;

    public Alumno(){

    }

    public Alumno(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Alumno(String nombre, String apellidos, int edad, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return edad == alumno.edad && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos)
                && Objects.equals(email, alumno.email) && Objects.equals(telefono, alumno.telefono);
    }

    public String esMayorEdad() {
        if (this.getEdad() >= 18) {
            return "Es mayor de edad";
        }
        else {
            return "No es mayor de edad";
        }
    }


}
