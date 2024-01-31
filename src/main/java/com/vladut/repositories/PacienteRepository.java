package com.vladut.repositories;

import com.vladut.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    List<Paciente> findByFechaNacimientoLessThanAndGenero(Date fechaNacimiento, String genero);

    boolean existsByEmailAndIdPacienteNot(String email, int  id );
}
