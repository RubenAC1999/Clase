package objetos;

public class Partido {

    private String id;
    private String fecha;
    private String hora;
    private String resultado;
    private String tipo;

    public Partido(String id, String fecha, String hora, String resultado, String tipo) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.resultado = resultado;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
