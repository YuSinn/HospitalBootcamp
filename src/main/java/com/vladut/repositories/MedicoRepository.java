package com.vladut.repositories;

import com.vladut.models.Material;
import com.vladut.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    List<Medico> findByDepartamentoIddepartamento(int id);

    List<Medico> findByDepartamentoNombreContaining(String nombre);

    List<Medico> findByEspecialidadContainingOrEspecialidadContaining(String t1,String t2);

    boolean existsByEmail(String email);
}
