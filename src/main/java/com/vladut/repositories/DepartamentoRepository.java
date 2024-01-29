package com.vladut.repositories;

import com.vladut.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    List<Departamento> findByDepartamentoContaining(String departamento);
}
