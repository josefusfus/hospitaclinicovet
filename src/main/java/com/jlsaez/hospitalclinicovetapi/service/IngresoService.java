package com.jlsaez.hospitalclinicovetapi.service;


import com.jlsaez.hospitalclinicovetapi.model.Ingreso;
import com.jlsaez.hospitalclinicovetapi.model.Mascota;
import com.jlsaez.hospitalclinicovetapi.repository.IngresoRepository;
import com.jlsaez.hospitalclinicovetapi.repository.MascotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoService {
    @Autowired
    private IngresoRepository ingresoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Ingreso> findAll() {
        return ingresoRepository.findAll();
    }

    public Ingreso save(Ingreso ingreso) {
        Optional<Mascota> mascota = mascotaRepository.findById(ingreso.getMascota().getId());
        if (mascota.isPresent() && "ALTA".equals(mascota.get().getEstado())) {
            if ("FINALIZADO".equals(ingreso.getEstado()) && ingreso.getFechaFinIngreso() == null) {
                throw new IllegalArgumentException("Ingreso no puede estar en estado FINALIZADO sin fecha de fin.");
            }
            ingreso.setMascota(mascota.get());
            return ingresoRepository.save(ingreso);
        } else {
            throw new IllegalArgumentException("La mascota está de baja o no existe.");
        }
    }

    public Optional<Ingreso> findById(Long id) {
        return ingresoRepository.findById(id);
    }

    public void deleteById(Long id) {
        Optional<Ingreso> ingreso = ingresoRepository.findById(id);
        if (ingreso.isPresent()) {
            Ingreso updatedIngreso = ingreso.get();
            updatedIngreso.setEstado("ANULADO");
            ingresoRepository.save(updatedIngreso);
        } else {
            throw new IllegalArgumentException("Ingreso con ID " + id + " no encontrado");
        }
    }

    public List<Ingreso> findByMascotaId(Long mascotaId) {
        return ingresoRepository.findByMascotaId(mascotaId);
    }
}