package com.vladut.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    private int idMedico;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "prapellido", nullable = false)
    private String prApellido;

    @Column(name = "sgapellido", nullable = true)
    private String sgApellido;

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "iddepartamento")
    private Departamento departamento;

    @ManyToMany(mappedBy = "medicos")
    @JsonIgnore
    private Set<Paciente> pacientes = new HashSet<>();

    public Medico() {
    }

    public Medico(int idMedico, String nombre, String prApellido, String sgApellido, String especialidad, String telefono, String email, Departamento departamento) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.prApellido = prApellido;
        this.sgApellido = sgApellido;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.departamento = departamento;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrApellido() {
        return prApellido;
    }

    public void setPrApellido(String prApellido) {
        this.prApellido = prApellido;
    }

    public String getSgApellido() {
        return sgApellido;
    }

    public void setSgApellido(String sgApellido) {
        this.sgApellido = sgApellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico=" + idMedico +
                ", nombre='" + nombre + '\'' +
                ", prApellido='" + prApellido + '\'' +
                ", sgApellido='" + sgApellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
