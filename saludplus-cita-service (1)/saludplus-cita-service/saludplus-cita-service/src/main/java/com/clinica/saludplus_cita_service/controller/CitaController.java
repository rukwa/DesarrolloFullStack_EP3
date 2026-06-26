package com.clinica.saludplus_cita_service.controller;

import com.clinica.saludplus_cita_service.model.Cita;
import com.clinica.saludplus_cita_service.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @PostMapping
    public Cita guardar(@RequestBody Cita cita) {
        return citaRepository.save(cita);
    }

    @GetMapping
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @GetMapping("/medico/{medicoId}")
    public String getCitasPorMedico(@PathVariable Integer medicoId) {
        List<Cita> citas = citaRepository.findByMedicoId(medicoId);
        if (citas.isEmpty()) {
            return "El médico con id " + medicoId + " no tiene citas en db_servicio_b";
        }
        return "Citas del médico " + medicoId + ": " + citas.size() + " cita(s) encontrada(s) en db_servicio_b";
    }
}