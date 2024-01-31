package com.vladut.controllers;

import com.vladut.models.Paciente;
import com.vladut.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") int id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);

        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @GetMapping("/pacientes/buscar")
    public ResponseEntity<List<Paciente>> buscarPorFechaNacimientoMayorYGenero(
            //poder utilizar fechas de nacimiento en formato ISO 8601 (por ejemplo, "1980-01-01")
            @RequestParam("fechaNacimiento") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaNacimiento,
            @RequestParam("genero") String genero) {

        List<Paciente> pacientes = pacienteRepository.findByFechaNacimientoLessThanAndGenero(fechaNacimiento, genero);

        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    @PostMapping("/pacientes/agregar")
    public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
        if (paciente.getPrApellido() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Paciente savedPaciente = pacienteRepository.save(paciente);
        return new ResponseEntity<>(savedPaciente, HttpStatus.CREATED);
    }

    @PutMapping("/pacientes-edit/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable("id") int id, @RequestBody Paciente updatedPaciente) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);

        if (existingPaciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Verificar si el correo electrónico ya está en uso por otro paciente
        String updatedEmail = updatedPaciente.getEmail();
        if (updatedEmail != null && pacienteRepository.existsByEmailAndIdPacienteNot(updatedEmail, id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Actualizar propiedades del paciente
        existingPaciente.setNombre(updatedPaciente.getNombre());
        existingPaciente.setPrApellido(updatedPaciente.getPrApellido());
        existingPaciente.setSgApellido(updatedPaciente.getSgApellido());
        existingPaciente.setFechaNacimiento(updatedPaciente.getFechaNacimiento());
        existingPaciente.setGenero(updatedPaciente.getGenero());
        existingPaciente.setDireccion(updatedPaciente.getDireccion());
        existingPaciente.setTelefono(updatedPaciente.getTelefono());
        existingPaciente.setEmail(updatedPaciente.getEmail());

        // Puedes actualizar la relación con médicos si es necesario

        Paciente updated = pacienteRepository.save(existingPaciente);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @DeleteMapping("/pacientes/delete/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable("id") int id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);

        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pacienteRepository.delete(paciente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
