package com.jlsaez.hospitalclinicovetapi.repository;

import com.jlsaez.hospitalclinicovetapi.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
