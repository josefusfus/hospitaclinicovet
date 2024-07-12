package com.jlsaez.hospitalclinicovetapi.controller;


import com.jlsaez.hospitalclinicovetapi.model.Mascota;
import com.jlsaez.hospitalclinicovetapi.model.Ingreso;
import com.jlsaez.hospitalclinicovetapi.service.MascotaService;
import com.jlsaez.hospitalclinicovetapi.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/hospitalclinicovet-api")
public class HospitalClinicoVetController {
    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private IngresoService ingresoService;

    @GetMapping("/ingreso")
    public List<Ingreso> getAllIngresos() {
        return ingresoService.findAll();
    }

    @PostMapping("/ingreso")
    public ResponseEntity<?> createIngreso(@RequestBody Ingreso ingreso) {
        try {
            Optional<Mascota> mascota = mascotaService.findById(ingreso.getMascota().getId());
            if (mascota.isPresent() && mascota.get().getDniResponsable().equals(ingreso.getDniRegistrador())) {
                ingreso.setEstado("ALTA");
                return ResponseEntity.ok(ingresoService.save(ingreso));
            } else {
                return ResponseEntity.badRequest().body("DNI del registrador no coincide con el responsable de la mascota");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ingreso")
    public ResponseEntity<?> updateIngreso(@RequestBody Ingreso ingreso) {
        try {
            Optional<Ingreso> existingIngreso = ingresoService.findById(ingreso.getId());
            if (existingIngreso.isPresent()) {
                return ResponseEntity.ok(ingresoService.save(ingreso));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/ingreso/{id}")
    public ResponseEntity<?> deleteIngreso(@PathVariable Long id) {
        try {
            ingresoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<?> getMascota(@PathVariable Long idMascota) {
        try {
            Optional<Mascota> mascota = mascotaService.findById(idMascota);
            return mascota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/mascota/{idMascota}/ingreso")
    public ResponseEntity<?> getIngresosByMascota(@PathVariable Long idMascota) {
        try {
            List<Ingreso> ingresos = ingresoService.findByMascotaId(idMascota);
            return ResponseEntity.ok(ingresos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/mascota")
    public ResponseEntity<?> createMascota(@RequestBody Mascota mascota) {
        try {
            return ResponseEntity.ok(mascotaService.save(mascota));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/mascota/{idMascota}")
    public ResponseEntity<?> deleteMascota(@PathVariable Long idMascota) {
        try {
            mascotaService.deleteById(idMascota);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}