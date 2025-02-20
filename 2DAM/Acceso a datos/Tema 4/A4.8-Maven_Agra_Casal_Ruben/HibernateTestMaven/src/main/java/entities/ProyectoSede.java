package entities;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "proyecto_sede")
public class ProyectoSede {

    @EmbeddedId
    private ProyectoSedeId proyectoSedeId;

    @ManyToOne
    @JoinColumn(name = "id_sede", insertable = false, updatable = false)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_proy", insertable = false, updatable = false)
    private Proyecto proyecto;


    public ProyectoSede() {
    }

    public ProyectoSede(ProyectoSedeId proyectoSedeId, Sede sede, Proyecto proyecto) {
        this.proyectoSedeId = proyectoSedeId;
        this.sede = sede;
        this.proyecto = proyecto;
    }

    public ProyectoSedeId getProyectoSedeId() {
        return proyectoSedeId;
    }

    public void setProyectoSedeId(ProyectoSedeId proyectoSedeId) {
        this.proyectoSedeId = proyectoSedeId;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "ID PROYECTO: " + getProyecto().getId() + " | ID SEDE: " + getSede().getId();
    }
}