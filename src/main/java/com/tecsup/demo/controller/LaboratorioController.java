package com.tecsup.demo.controller;

import com.tecsup.demo.model.Laboratorio;
import com.tecsup.demo.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laboratorio")
public class LaboratorioController {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @GetMapping
    public List<Laboratorio> obtenerLaboratorio() {
        return laboratorioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Laboratorio> obtenerLaboratorio(@PathVariable Long id) {
        return laboratorioRepository.findById(id);
    }

    @PostMapping
    public Laboratorio guardarLaboratorio(@RequestBody Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @PutMapping("/{id}")
    public Laboratorio actualizarLaboratorio(@RequestBody Laboratorio laboratorio, @PathVariable Long id) {
        laboratorio.setCodLab(id);
        return laboratorioRepository.save(laboratorio);
    }

    @DeleteMapping("/{id}")
    public void eliminarLaboratorio(@PathVariable Long id) {
        laboratorioRepository.deleteById(id);
    }
}
