package com.vladut.models;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    public Departamento() {
    }

    public Departamento(int idDepartamento, String nombre, String descripcion, Inventario inventario) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inventario = inventario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", inventario=" + inventario +
                '}';
    }
}
