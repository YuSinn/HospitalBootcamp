package com.vladut.controllers;

import com.vladut.models.Departamento;
import com.vladut.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class DepartamentoController {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @GetMapping("/departamento")
    public ResponseEntity<List<Departamento>> getAll(@RequestParam(name="departamento",required = false) String departamento) {
        List<Departamento> res = new ArrayList<>();
        if (departamento == null) {
            departamentoRepository.findAll().forEach(res::add);
        } else {
            departamentoRepository.findByDescripcionContaining(departamento).forEach(res::add);
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/departamento/{id}")
    public ResponseEntity<Departamento> getCountry(@PathVariable("id") int id) {
        Departamento departamento = departamentoRepository.findById(id).orElse(null);

        if (departamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        }
    }
    @GetMapping("/departamento/nombre/{nombre}")
    public ResponseEntity<List<Departamento>> getDepartamentosByNombre(@PathVariable String nombre) {
        List<Departamento> departamentos = departamentoRepository.findByNombreStartingWith(nombre);

        if (departamentos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(departamentos, HttpStatus.OK);
        }
    }

    @PostMapping("/departamento")
    public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
        if (departamento.getNombre() == null || departamento.getNombre().isEmpty() ||
                departamento.getDescripcion() == null || departamento.getDescripcion().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Departamento departamentoGuardado = departamentoRepository.save(departamento);

        return new ResponseEntity<>(departamentoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/departamento/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable("id") int id,
            @RequestBody Departamento departamento) {

        Departamento existingDepartamento = departamentoRepository.findById(id).orElse(null);

        if (existingDepartamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualizar los campos del departamento existente con los datos
        existingDepartamento.setNombre(departamento.getNombre());
        existingDepartamento.setDescripcion(departamento.getDescripcion());

        // Guardar los cambios en el repositorio
        departamentoRepository.save(existingDepartamento);

        return new ResponseEntity<>(existingDepartamento, HttpStatus.OK);
    }

    @DeleteMapping("/departamento/{id}")
    public ResponseEntity<String> deleteDepartamento(@PathVariable int id) {
        try {
            departamentoRepository.deleteById(id);
            return new ResponseEntity<>("Departamento eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el departamento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


