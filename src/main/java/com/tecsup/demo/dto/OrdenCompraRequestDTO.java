package com.tecsup.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrdenCompraRequestDTO {
    private LocalDate fechaEmision;
    private String situacion;
    private BigDecimal total;
    private String nroFacturaProv;
    private Long codLab;

    public OrdenCompraRequestDTO() {
    }

    public OrdenCompraRequestDTO(LocalDate fechaEmision, String situacion, BigDecimal total, String nroFacturaProv, Long codLab) {
        this.fechaEmision = fechaEmision;
        this.situacion = situacion;
        this.total = total;
        this.nroFacturaProv = nroFacturaProv;
        this.codLab = codLab;
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

    public Long getCodLab() {
        return codLab;
    }

    public void setCodLab(Long codLab) {
        this.codLab = codLab;
    }
}
