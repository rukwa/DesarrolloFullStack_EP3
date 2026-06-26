package com.clinica.saludplus_medico_service.repository;

import com.clinica.saludplus_medico_service.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {}