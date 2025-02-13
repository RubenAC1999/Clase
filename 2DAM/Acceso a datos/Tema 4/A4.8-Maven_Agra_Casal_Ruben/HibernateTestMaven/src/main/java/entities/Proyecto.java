package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proy", length = 11, nullable = false)
    private int id;

    @Column(name = "f_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fInicio;

    @Column(name = "f_fin")
    @Temporal(TemporalType.DATE)
    private Date fFin;

    @Column(name = "nom_proy", length = 20, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "proyecto")
    private List<ProyectoSede> proyectoSedes;

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

    public List<ProyectoSede> getProyectoSedes() {
        return proyectoSedes;
    }

    public void setProyectoSedes(List<ProyectoSede> proyectoSedes) {
        this.proyectoSedes = proyectoSedes;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t--\tInicio: " + fInicio + "\t--\tFin: " + fFin + "\t--\tNombre: " + nombre;

    }
}
