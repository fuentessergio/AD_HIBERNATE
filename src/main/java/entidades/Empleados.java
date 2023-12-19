package entidades;

import java.math.BigDecimal;
import java.sql.Date;

public class Empleados {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Date fechaContratacion;
    private String idTrabajo;
    private BigDecimal salario;
    private BigDecimal comision;
    private Integer idDirector;
    private Integer idDepartamento;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(String idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleados empleados = (Empleados) o;

        if (idEmpleado != empleados.idEmpleado) return false;
        if (nombre != null ? !nombre.equals(empleados.nombre) : empleados.nombre != null) return false;
        if (apellido != null ? !apellido.equals(empleados.apellido) : empleados.apellido != null) return false;
        if (email != null ? !email.equals(empleados.email) : empleados.email != null) return false;
        if (telefono != null ? !telefono.equals(empleados.telefono) : empleados.telefono != null) return false;
        if (fechaContratacion != null ? !fechaContratacion.equals(empleados.fechaContratacion) : empleados.fechaContratacion != null)
            return false;
        if (idTrabajo != null ? !idTrabajo.equals(empleados.idTrabajo) : empleados.idTrabajo != null) return false;
        if (salario != null ? !salario.equals(empleados.salario) : empleados.salario != null) return false;
        if (comision != null ? !comision.equals(empleados.comision) : empleados.comision != null) return false;
        if (idDirector != null ? !idDirector.equals(empleados.idDirector) : empleados.idDirector != null) return false;
        if (idDepartamento != null ? !idDepartamento.equals(empleados.idDepartamento) : empleados.idDepartamento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleado;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (fechaContratacion != null ? fechaContratacion.hashCode() : 0);
        result = 31 * result + (idTrabajo != null ? idTrabajo.hashCode() : 0);
        result = 31 * result + (salario != null ? salario.hashCode() : 0);
        result = 31 * result + (comision != null ? comision.hashCode() : 0);
        result = 31 * result + (idDirector != null ? idDirector.hashCode() : 0);
        result = 31 * result + (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return result;
    }
}
