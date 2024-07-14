package com.jlsaez.hospitalclinicovetapi.controller;


import com.jlsaez.hospitalclinicovetapi.model.Mascota;
import com.jlsaez.hospitalclinicovetapi.model.Ingreso;
import com.jlsaez.hospitalclinicovetapi.service.MascotaService;
import com.jlsaez.hospitalclinicovetapi.service.IngresoService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Obtener todos los ingresos", description = "Devuelve una lista de todos los ingresos registrados en el hospital clínico veterinario." + "\n" + "Corresponde al primer endpoint requerido en la prueba /ingreso:\n" +
            "\n" +
            "Usando una petición HTTP GET: Devolverá una lista de todos los ingresos que tiene registrados el Hospital Clínico Veterinario.")
    @GetMapping("/ingreso")
    public List<Ingreso> getAllIngresos() {
        return ingresoService.findAll();
    }

    @Operation(summary = "Crear un nuevo ingreso", description = "Crea un nuevo ingreso para una mascota específica" + "\n" + "Corresponde al segundo endpoint requerido en la prueba /ingreso:\n" +
            "\n" +
            "Usando una petición HTTP POST + un JSON con el ID de la mascota (previamente registrada) y fecha de ingreso: Creará un nuevo ingreso en base de datos para la mascota indicada, con estado “ALTA”")
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

    @Operation(summary = "Modificar un ingreso", description = "Modifica la información de un ingreso existente" + "\n" + "Corresponde al tercer endpoint requerido en la prueba /ingreso:\n" +
            "\n" +
            "Usando una petición HTTP PUT + el ID de la mascota y del ingreso + JSON de datos: Modificará una La información de un ingreso, cambiando su estado y/o la fecha de fin de ingreso")
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

    @Operation(summary = "Anular un ingreso", description = "Anula un ingreso existente" + "\n" + "Corresponde al cuarto endpoint requerido en la prueba /ingreso:\n" +
            "\n" + "Usando una petición HTTP DELETE + el ID del ingreso: Modifica el esado del ingreso a “ANULADO")
    @DeleteMapping("/ingreso/{id}")
    public ResponseEntity<?> deleteIngreso(@PathVariable Long id) {
        try {
            ingresoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener datos de una mascota", description = "Devuelve todos los datos de una mascota específica"  + "\n" + "Corresponde al quinto endpoint requerido en la prueba /mascota/{idMascota}:\n" +
            "Usando una petición HTTP GET + el ID de la mascota: Se devolverá todos los datos pertenecientes a la mascota cuyo ID coincida con {idMascota}")
    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<?> getMascota(@PathVariable Long idMascota) {
        try {
            Optional<Mascota> mascota = mascotaService.findById(idMascota);
            return mascota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener ingresos de una mascota", description = "Devuelve un listado de todos los ingresos de una mascota específica" + "\n" + "Corresponde al sexto endpoint requerido en la prueba /mascota/{idMascota}/ingreso::" + "\n" + "Usando una petición HTTP GET + el ID de la mascota: Devolverá un listado con todos los ingresos que ha tenido la mascota con {ID idMascota}")
    @GetMapping("/mascota/{idMascota}/ingreso")
    public ResponseEntity<?> getIngresosByMascota(@PathVariable Long idMascota) {
        try {
            List<Ingreso> ingresos = ingresoService.findByMascotaId(idMascota);
            return ResponseEntity.ok(ingresos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Crear una nueva mascota", description = "Crea una nueva mascota en el sistema" + "\n" + "Corresponde al septimo endpoint requerido en la prueba /mascota:" + "\n" + "Usando una petición HTTP POST + un JSON con los datos de una mascota: Se guardará en base de datos dicha mascota y se devolverá un JSON con toda la información guardada (que debe incluir el ID de esa mascota en el sistema).")
    @PostMapping("/mascota")
    public ResponseEntity<?> createMascota(@RequestBody Mascota mascota) {
        try {
            return ResponseEntity.ok(mascotaService.save(mascota));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Dar de baja una mascota", description = "Da de baja una mascota en el sistema" + "\n" + "Corresponde al septimo endpoint requerido en la prueba /mascota:" + "\n" + "Usando una petición HTTP DELETE + el ID de la mascota: Da de baja la mascota en el sistema (no se podrá hacer ninguna operación con ella), pero NO la borra de base de datos.")
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