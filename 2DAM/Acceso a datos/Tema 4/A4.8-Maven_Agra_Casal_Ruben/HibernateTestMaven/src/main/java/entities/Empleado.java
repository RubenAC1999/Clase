

package entities;


import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name = "dni", length = 9, nullable = false)
    private String dni;

    @Column(name = "nom_emp", length = 40, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_depto", referencedColumnName = "id_depto")
    private Departamento departamento;


    @OneToOne(mappedBy = "empleado")
    private DatosProfEmpleado datosProf;

    public Empleado() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public DatosProfEmpleado getDatosProf() {
        return datosProf;
    }

    public void setDatosProf(DatosProfEmpleado datosProf) {
        this.datosProf = datosProf;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\t--\tNombre: " + nombre + "\t--\tID_Depto: " + departamento.getId();
    }
}