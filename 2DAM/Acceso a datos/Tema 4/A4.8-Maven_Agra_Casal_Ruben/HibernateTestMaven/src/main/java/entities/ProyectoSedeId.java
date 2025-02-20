package entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProyectoSedeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_proy", referencedColumnName = "id_proy", nullable = false)
    private Proyecto idProyecto;

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id_sede", nullable = false)
    private Sede idSede;

    public ProyectoSedeId() {
    }

    public ProyectoSedeId(Proyecto idProyecto, Sede idSede) {
        this.idProyecto = idProyecto;
        this.idSede = idSede;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }
}