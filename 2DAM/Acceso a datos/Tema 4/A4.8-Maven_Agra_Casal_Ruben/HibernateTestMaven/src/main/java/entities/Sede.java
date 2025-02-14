package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede", length = 11, nullable = false)
    private int id;

    @Column(name = "nom_sede", length = 255, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "sede")
    private List<Departamento> departamento;

    @OneToMany(mappedBy = "sede")
    private List<ProyectoSede> proyectoSede;

    public Sede() {
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

    public List<Departamento> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<Departamento> departamento) {
        this.departamento = departamento;
    }

    public List<ProyectoSede> getProyectoSede() {
        return proyectoSede;
    }

    public void setProyectoSede(List<ProyectoSede> proyectoSede) {
        this.proyectoSede = proyectoSede;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t--\tNombre: " + nombre;
    }
}