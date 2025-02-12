package entities;

public class Empleado {
    private String dni;
    private String nombre;
    private int idDepartamento;
    private Departamento departamento;

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

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
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
}
