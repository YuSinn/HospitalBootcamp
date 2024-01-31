package com.vladut.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaciente")
    private int idPaciente;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "prapellido", nullable = false)
    private String prApellido;

    @Column(name = "sgapellido", nullable = true)
    private String sgApellido;

    @Column(name="fechanacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name="genero")
    private String genero;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "asignacion_paciente_medico",
            joinColumns = @JoinColumn(name = "idpaciente"),
            inverseJoinColumns = @JoinColumn(name = "idmedico")
    )
    private Set<Medico> medicos = new HashSet<>();

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombre, String prApellido, String sgApellido, Date fechaNacimiento, String genero, String direccion, String telefono, String email ) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.prApellido = prApellido;
        this.sgApellido = sgApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public Set<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(Set<Medico> medicos) {
        this.medicos = medicos;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nombre='" + nombre + '\'' +
                ", prApellido='" + prApellido + '\'' +
                ", sgApellido='" + sgApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
