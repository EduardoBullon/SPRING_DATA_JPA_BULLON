package com.tecsup.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="laboratorio")
public class Laboratorio {
    @Id
    @Column(name = "cod_lab")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codLab;

    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "contacto")
    private String contacto;

    @OneToMany(mappedBy = "laboratorio", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrdenCompra> ordenesCompra;

    public Laboratorio() {
    }

    public Laboratorio(Long codLab, String razonSocial, String direccion, String telefono, String email, String contacto, List<OrdenCompra> ordenesCompra) {
        this.codLab = codLab;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contacto = contacto;
        this.ordenesCompra = ordenesCompra;
    }

    public Long getCodLab() {
        return codLab;
    }

    public void setCodLab(Long codLab) {
        this.codLab = codLab;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<OrdenCompra> getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(List<OrdenCompra> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }
}
