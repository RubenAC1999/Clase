package objetos;

public class Equipo {

    private String nombre;
    private String estadio;
    private String direccion;
    private int capacidad;
    private int fechaFundacion;
    private String nombreGrupo;

    public Equipo(String nombre, String estadio, String direccion, int capacidad, int fechaFundacion, String nombreGrupo) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.fechaFundacion = fechaFundacion;
        this.nombreGrupo = nombreGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(int fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

}
