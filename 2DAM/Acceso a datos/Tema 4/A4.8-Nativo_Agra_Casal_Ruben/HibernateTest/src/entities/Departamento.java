package entities;

public class Departamento {
    private int id;
    private String nombre;
    private Sede sede;

    public Departamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t--\tNombre: " + nombre + "\t--\tID_SEDE: " + sede.getId();
    }
}
