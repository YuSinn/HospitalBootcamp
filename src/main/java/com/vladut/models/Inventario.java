package com.vladut.models;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Inventario() {
    }

    public Inventario(int idInventario, String nombre, int cantidad, String descripcion) {
        this.idInventario = idInventario;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "idInventario=" + idInventario +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
