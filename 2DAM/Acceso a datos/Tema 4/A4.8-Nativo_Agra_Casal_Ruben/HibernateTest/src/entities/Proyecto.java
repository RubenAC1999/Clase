package entities;

import java.util.Date;

public class Proyecto {
    private int id;
    private Date fInicio;
    private Date fFin;
    private String nombre;

    public Proyecto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getfInicio() {
        return fInicio;
    }

    public void setfInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getfFin() {
        return fFin;
    }

    public void setfFin(Date fFin) {
        this.fFin = fFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
