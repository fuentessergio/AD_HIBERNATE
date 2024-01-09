package entidades;

import java.io.Serializable;
import java.sql.Date;

public class HistorialTrabPK implements Serializable {
    private int idEmpleado;
    private Date fechaInicio;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistorialTrabPK that = (HistorialTrabPK) o;

        if (idEmpleado != that.idEmpleado) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleado;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        return result;
    }
}
