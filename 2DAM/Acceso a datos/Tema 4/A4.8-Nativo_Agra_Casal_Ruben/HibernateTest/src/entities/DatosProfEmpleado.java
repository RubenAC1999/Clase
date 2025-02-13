package entities;

public class DatosProfEmpleado {
    private String dni;
    private Empleado empleado;
    private String categoria;
    private float sueldoBrutoAnual;

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
                ", empleado=" + empleado +
                ", categoria='" + categoria + '\'' +
                ", sueldoBrutoAnual=" + sueldoBrutoAnual +
                '}';
    }
}
