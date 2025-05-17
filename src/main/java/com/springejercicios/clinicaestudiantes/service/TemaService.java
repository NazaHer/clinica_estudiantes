package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Tema;
import com.springejercicios.clinicaestudiantes.repository.InTemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements InTemaService {
    
    @Autowired
    private InTemaRepository temaRepo;

    @Override
    public void saveTema(Tema t) {
        temaRepo.save(t);
    }

    @Override
    public void editTema(Long id, String nombre, String descripcion) {
        Tema t = getTema(id);
        t.actualizarValores(nombre, descripcion);
        temaRepo.save(t);
    }

    @Override
    public Tema getTema(Long id) {
        return temaRepo.findById(id).orElse(null);
    }
    
}
