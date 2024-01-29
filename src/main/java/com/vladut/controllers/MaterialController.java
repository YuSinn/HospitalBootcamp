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
    public ResponseEntity<Material> getCity(@PathVariable("id") int id) {
        Material material = materialRepository.findById(id)
                .orElse(null);
        if (material == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(material, HttpStatus.OK);
        }
    }

    // Utilizo el formato estándar de la API REST para obtener los registros relacionados
    // de otra tabla. El campo id va enmedio de las dos
    @GetMapping("/departamento/{id}/material")
    public ResponseEntity<List<Material>> getAllByDepartment(@PathVariable("id") int id) {
        List<Material> res = new ArrayList<>();
        // Usamos la consulta de JPA para buscar por el id de country
        materialRepository.findByDepartamentoDepartamentoId(id).forEach(res::add);
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

    @PutMapping("/city/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") int id, @RequestBody City city) {
        City temp = cityRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        temp.setCity(city.getCity());
        if (city.getCountry() != null) {
            Country country = countryRepository.findById(city.getCountry().getCountryId()).orElse(null);
            if (country != null) {
                temp.setCountry(country);
            }
        }
        return new ResponseEntity<>(cityRepository.save(temp), HttpStatus.OK);
    }

    // Borro todas las ciudades de un país, ojo con esto que nos cargamos los datos a lo loco
    @DeleteMapping("/country/{id}/city")
    public ResponseEntity<HttpStatus> deleteCityCountry(@PathVariable("id") int id) {
        // No recupero el country, me basta con saber que existe
        if (!countryRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            cityRepository.deleteByCountryCountryId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") int id) {
        cityRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
