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

    @Column(name = "f_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fInicio;

    @Column(name = "f_fin")
    @Temporal(TemporalType.DATE)
    private Date fFin;

    public ProyectoSede() {
    }

    public ProyectoSedeId getProyectoSedeId() {
        return proyectoSedeId;
    }

    public void setProyectoSedeId(ProyectoSedeId proyectoSedeId) {
        this.proyectoSedeId = proyectoSedeId;
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
}