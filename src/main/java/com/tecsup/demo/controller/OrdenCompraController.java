package com.tecsup.demo.controller;

import com.tecsup.demo.dto.OrdenCompraRequestDTO;
import com.tecsup.demo.model.Laboratorio;
import com.tecsup.demo.model.OrdenCompra;
import com.tecsup.demo.repository.LaboratorioRepository;
import com.tecsup.demo.repository.OrdenCompraRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordencompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    // Obtener todas las órdenes de compra
    @GetMapping
    public List<OrdenCompra> obtenerTodasLasOrdenes() {
        return ordenCompraRepository.findAll();
    }

    // Obtener una orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtenerOrdenPorId(@PathVariable Long id) {
        Optional<OrdenCompra> ordenOpt = ordenCompraRepository.findById(id);
        return ordenOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva orden de compra
    @PostMapping
    public ResponseEntity<OrdenCompra> guardarOrdenCompra(@RequestBody OrdenCompraRequestDTO request) {
        Optional<Laboratorio> laboratorioOpt = laboratorioRepository.findById(request.getCodLab());

        if (laboratorioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setFechaEmision(request.getFechaEmision());
        ordenCompra.setSituacion(request.getSituacion());
        ordenCompra.setTotal(request.getTotal());
        ordenCompra.setNroFacturaProv(request.getNroFacturaProv());
        ordenCompra.setLaboratorio(laboratorioOpt.get());

        OrdenCompra ordenGuardada = ordenCompraRepository.save(ordenCompra);
        return ResponseEntity.ok(ordenGuardada);
    }

    // Actualizar orden de compra existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompra> actualizarOrdenCompra(@RequestBody OrdenCompraRequestDTO request, @PathVariable Long id) {
        Optional<OrdenCompra> ordenExistente = ordenCompraRepository.findById(id);
        if (ordenExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Laboratorio> laboratorioOpt = laboratorioRepository.findById(request.getCodLab());
        if (laboratorioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        OrdenCompra ordenCompra = ordenExistente.get();
        ordenCompra.setFechaEmision(request.getFechaEmision());
        ordenCompra.setSituacion(request.getSituacion());
        ordenCompra.setTotal(request.getTotal());
        ordenCompra.setNroFacturaProv(request.getNroFacturaProv());
        ordenCompra.setLaboratorio(laboratorioOpt.get());

        OrdenCompra ordenActualizada = ordenCompraRepository.save(ordenCompra);
        return ResponseEntity.ok(ordenActualizada);
    }

    // Eliminar una orden de compra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrdenCompra(@PathVariable Long id) {
        if (!ordenCompraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ordenCompraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
