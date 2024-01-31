package com.vladut.controllers;

import com.vladut.models.Departamento;
import com.vladut.models.Medico;
import com.vladut.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> getAllMedicos() {
        List<Medico> medicos = medicoRepository.findAll();

        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }
    @GetMapping("/medicosPorDepartamento/id/{idDepartamento}")
    public ResponseEntity<List<Medico>> getMedicosPorDepartamento(@PathVariable int idDepartamento) {
        List<Medico> medicos = medicoRepository.findByDepartamentoIddepartamento(idDepartamento);

        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/medicosPorDepartamento/nombre/{nombreDepartamento}")
    public ResponseEntity<List<Medico>> getMedicosPorDepartamento(@PathVariable String nombreDepartamento) {
        List<Medico> medicos = medicoRepository.findByDepartamentoNombreContaining(nombreDepartamento);

        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }
    @GetMapping("/especialidad")
    public ResponseEntity<List<Medico>> getMedicosByEspecialidad(
            @RequestParam(name = "t1") String t1,
            @RequestParam(name = "t2") String t2) {

        List<Medico> medicos = medicoRepository.findByEspecialidadContainingOrEspecialidadContaining(t1, t2);

        if (medicos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        }
    }
    @PostMapping("/nuevoMedico")
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        try {
            // Validar que el correo electrónico no esté duplicado
            if (medicoRepository.existsByEmail(medico.getEmail())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo electrónico ya está en uso.");
            }

            // Validar que el primer apellido no sea nulo
            if (medico.getPrApellido() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El primer apellido es obligatorio.");
            }
            Departamento departamento = medico.getDepartamento();

            if(departamento.getDescripcion()==null||departamento.getNombre()==null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departamento no puede tener campos nulos.");
            }

            Medico nuevoMedico = new Medico(0, medico.getNombre(), medico.getPrApellido(), medico.getSgApellido(), medico.getEspecialidad(), medico.getTelefono(), medico.getEmail(), departamento);

            // Puedes devolver el nuevo médico creado en la respuesta
            return new ResponseEntity<>(medicoRepository.save(nuevoMedico), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el médico.", e);
        }
    }
    @PutMapping("/edit-medico/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable("id") int id, @RequestBody Medico updatedMedico) {
        Medico existingMedico = medicoRepository.findById(id).orElse(null);

        if (existingMedico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualizar los campos del médico existente con los valores proporcionados
        existingMedico.setNombre(updatedMedico.getNombre());
        existingMedico.setPrApellido(updatedMedico.getPrApellido());
        existingMedico.setSgApellido(updatedMedico.getSgApellido());
        existingMedico.setEspecialidad(updatedMedico.getEspecialidad());
        existingMedico.setEmail(updatedMedico.getEmail());
        existingMedico.setTelefono(updatedMedico.getTelefono());

        // Guardar el médico actualizado en la base de datos
        Medico updatedEntity = medicoRepository.save(existingMedico);

        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable("id") int id) {
        Medico existingMedico = medicoRepository.findById(id).orElse(null);

        if (existingMedico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Eliminar el médico de la base de datos
        medicoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
