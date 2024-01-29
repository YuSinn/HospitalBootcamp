package com.vladut.repositories;

import com.vladut.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    List<Material> findByDepartamentoDepartamentoId(int id);

    @Transactional
    void deleteByMaterialMaterialId(int id);
}
