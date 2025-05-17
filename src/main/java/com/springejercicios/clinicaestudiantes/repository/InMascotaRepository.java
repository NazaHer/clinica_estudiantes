package com.springejercicios.clinicaestudiantes.repository;

import com.springejercicios.clinicaestudiantes.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMascotaRepository extends JpaRepository <Mascota, Long> {
    
}
