package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_depto", length = 11, nullable = false)
    private int id;

    @Column(name = "nom_depto", length = 32, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id_sede", nullable = false)
    private Sede sede;

    public Departamento() {
    }

    public Departamento(String nombre, Sede sede) {
        this.nombre = nombre;
        this.sede = sede;
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