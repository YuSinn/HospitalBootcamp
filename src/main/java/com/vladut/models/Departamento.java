package com.vladut.models;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartamento")
    private int iddepartamento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;


    public Departamento() {
    }

    public Departamento(int idDepartamento, String nombre, String descripcion) {
        this.iddepartamento = idDepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdDepartamento() {
        return iddepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.iddepartamento = idDepartamento;
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

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + iddepartamento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
