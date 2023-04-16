package org.example.models;

import org.example.enums.ClasificacionRiesgo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente implements Serializable {

    private int idCliente;
    private String nombre = "";
    private String apellido = "";
    private String cedula = "";
    private LocalDate fNacimiento;
    private boolean statuslaboral;
    private ClasificacionRiesgo nivelRiesgo = ClasificacionRiesgo.B;
    private List<Cuenta> cuentas = new ArrayList<>();

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public boolean isStatuslaboral() {
        return statuslaboral;
    }

    public void setStatuslaboral(boolean statuslaboral) {
        this.statuslaboral = statuslaboral;
    }

    public ClasificacionRiesgo getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(ClasificacionRiesgo nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List getCuentas() {

        return cuentas;
    }

    public void setCuentas(List cuentas) {
        this.cuentas = cuentas;
    }
}
