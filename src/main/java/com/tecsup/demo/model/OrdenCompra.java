package com.tecsup.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orden_compra")
public class OrdenCompra {
    @Id
    @Column(name = "nro_orden_c")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroOrdenC;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "situacion")
    private String situacion;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "nro_factura_prov")
    private String nroFacturaProv;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_lab", nullable = false)
    private Laboratorio laboratorio;

    public OrdenCompra() {
    }

    public OrdenCompra(Long nroOrdenC, LocalDate fechaEmision, String situacion, BigDecimal total, String nroFacturaProv, Laboratorio laboratorio) {
        this.nroOrdenC = nroOrdenC;
        this.fechaEmision = fechaEmision;
        this.situacion = situacion;
        this.total = total;
        this.nroFacturaProv = nroFacturaProv;
        this.laboratorio = laboratorio;
    }

    public Long getNroOrdenC() {
        return nroOrdenC;
    }

    public void setNroOrdenC(Long nroOrdenC) {
        this.nroOrdenC = nroOrdenC;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getNroFacturaProv() {
        return nroFacturaProv;
    }

    public void setNroFacturaProv(String nroFacturaProv) {
        this.nroFacturaProv = nroFacturaProv;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
