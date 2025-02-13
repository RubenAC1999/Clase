package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado_datos_prof")
public class DatosProfEmpleado {

    @Id
    @Column(name = "dni", length = 9, nullable = false)
    private String dni;

    @Column(name = "categoria", length = 2, nullable = false)
    private String categoria;

    @Column(name = "sueldo_bruto_anual", nullable = false)
    private float sueldoBrutoAnual;

    @OneToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    private Empleado empleado;

    public DatosProfEmpleado() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getSueldoBrutoAnual() {
        return sueldoBrutoAnual;
    }

    public void setSueldoBrutoAnual(float sueldoBrutoAnual) {
        this.sueldoBrutoAnual = sueldoBrutoAnual;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "DatosProfEmpleado{" +
                "dni='" + dni + '\'' +
                ", categoria='" + categoria + '\'' +
                ", sueldoBrutoAnual=" + sueldoBrutoAnual +
                ", empleado=" + empleado +
                '}';
    }
}
