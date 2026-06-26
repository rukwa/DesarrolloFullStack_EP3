package com.clinica.saludplus_cita_service.repository;

import com.clinica.saludplus_cita_service.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByMedicoId(Integer medicoId);
}