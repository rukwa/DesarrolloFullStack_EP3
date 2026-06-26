package com.clinica.saludplus_medico_service.controller;

import com.clinica.saludplus_medico_service.model.Medico;
import com.clinica.saludplus_medico_service.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    private final RestTemplate restTemplate;

    public MedicoController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @PostMapping
    public Medico guardar(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    @GetMapping
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @GetMapping("/{id}/citas")
    public String checkCitas(@PathVariable Long id) {
        String url = "http://localhost:8082/citas/medico/" + id;
        return restTemplate.getForObject(url, String.class);
    }
}