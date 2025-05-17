package com.springejercicios.clinicaestudiantes.service;

import com.springejercicios.clinicaestudiantes.model.Curso;
import com.springejercicios.clinicaestudiantes.model.Tema;
import com.springejercicios.clinicaestudiantes.repository.InCursoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements InCursoService {
    
    @Autowired
    private InCursoRepository cursoRepo;

    @Override
    public void saveCurso(Curso c) {
        cursoRepo.save(c);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public List<Tema> getTemasDelCurso(Long id) {
        Curso curso = cursoRepo.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        return curso.getTemas();
    }

    @Override
    public List<Curso> getCursosJava() {
        List<Curso> lista = new ArrayList<>();
        for (Curso c : cursoRepo.findAll()) {
            if(esSobreJava(c.getNombre())){
                lista.add(c);
            }
        }
        return lista;
    }
    
    private boolean esSobreJava(String texto){
        return texto.toLowerCase().contains("java");
    }

    @Override
    public void editCurso(Long id_Original, String nuevoNombre, String nuevaModalidad, LocalDate nuevaFecha, List<Tema> nuevosTemas) {
        Curso c = cursoRepo.findById(id_Original).orElse(null);
        c.actualizarValores(nuevoNombre, nuevaModalidad, nuevaFecha, nuevosTemas);
        cursoRepo.save(c);
    }

    @Override
    public Curso getCurso(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }
    
}
