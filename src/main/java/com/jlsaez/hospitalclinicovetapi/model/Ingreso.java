package com.jlsaez.hospitalclinicovetapi.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaAltaIngreso;

    @Temporal(TemporalType.DATE)
    private Date fechaFinIngreso;

    private String estado; // ALTA, ANULADO, HOSPITALIZACION, FINALIZADO

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;

    private String dniRegistrador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaAltaIngreso() {
        return fechaAltaIngreso;
    }

    public void setFechaAltaIngreso(Date fechaAltaIngreso) {
        this.fechaAltaIngreso = fechaAltaIngreso;
    }

    public Date getFechaFinIngreso() {
        return fechaFinIngreso;
    }

    public void setFechaFinIngreso(Date fechaFinIngreso) {
        this.fechaFinIngreso = fechaFinIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getDniRegistrador() {
        return dniRegistrador;
    }

    public void setDniRegistrador(String dniRegistrador) {
        this.dniRegistrador = dniRegistrador;
    }

    // Getters y Setters
}
