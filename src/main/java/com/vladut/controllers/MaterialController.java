package com.vladut.controllers;

import com.vladut.models.Departamento;
import com.vladut.models.Material;
import com.vladut.repositories.DepartamentoRepository;
import com.vladut.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class MaterialController {
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    MaterialRepository materialRepository;

    @GetMapping("/material")
    public ResponseEntity<List<Material>> getAll() {
        List<Material> res = new ArrayList<>();
        materialRepository.findAll().forEach(res::add);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    /**
     * Test swagger
     * @param id
     * @return
     */
    @GetMapping("/material/{id}")
    public ResponseEntity<Material> getMaterial(@PathVariable("id") int id) {
        Material material = materialRepository.findById(id)
                .orElse(null);
        if (material == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(material, HttpStatus.OK);
        }
    }

    @GetMapping("/material/por-nombre/{nombre}")
    public ResponseEntity<List<Material>> getMaterialesPorNombre(@PathVariable String nombre) {
        List<Material> materiales = materialRepository.findByNombreStartingWith(nombre);
        return new ResponseEntity<>(materiales, HttpStatus.OK);
    }
    @GetMapping("/departamento/{id}/material")
    public ResponseEntity<List<Material>> getAllByDepartment(@PathVariable("id") int id) {
        List<Material> res = new ArrayList<>();

        materialRepository.findByDepartamentoIddepartamento(id).forEach(res::add);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/departamento/{id}/material")
    public ResponseEntity<Material> addMaterial(@PathVariable("id") int id, @RequestBody Material material) {
        Departamento departamento = departamentoRepository.findById(id).orElse(null);
        if (departamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Material temp = new Material(0,material.getNombre(),material.getCantidad(), material.getDescripcion(), departamento);
        return new ResponseEntity<>(materialRepository.save(temp), HttpStatus.CREATED);
    }

    @PutMapping("/material/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable("id") int id, @RequestBody Material material) {
        Material temp = materialRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        temp.setNombre(material.getNombre());
        if (material.getDepartamento() != null) {
            Departamento departamento = departamentoRepository.findById(material.getDepartamento().getIdDepartamento()).orElse(null);
            if (departamento != null) {
                temp.setDepartamento(departamento);
            }
        }
        return new ResponseEntity<>(materialRepository.save(temp), HttpStatus.OK);
    }

    @DeleteMapping("/departamento/{id}/material")
    public ResponseEntity<HttpStatus> deleteMaterialDepartamento(@PathVariable("id") int id) {

        if (!departamentoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            materialRepository.deleteByDepartamentoIddepartamento(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/material/{id}")
    public ResponseEntity<HttpStatus> deleteMaterial(@PathVariable("id") int id) {
        materialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
