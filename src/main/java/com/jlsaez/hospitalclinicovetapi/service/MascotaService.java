package com.jlsaez.hospitalclinicovetapi.service;



import com.jlsaez.hospitalclinicovetapi.model.Mascota;
import com.jlsaez.hospitalclinicovetapi.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Optional<Mascota> findById(Long id) {
        return mascotaRepository.findById(id);
    }

    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    public void deleteById(Long id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        if (mascota.isPresent()) {
            Mascota updatedMascota = mascota.get();
            // Lógica de baja: podríamos añadir un campo booleano `activo` para marcar la baja
            // pero según los datos proporcionados, simplemente la retornamos
            mascotaRepository.save(updatedMascota);
        } else {
            throw new IllegalArgumentException("Mascota con ID " + id + " no encontrada");
        }
    }
}