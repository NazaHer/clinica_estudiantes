package com.springejercicios.clinicaestudiantes.controller;

import com.springejercicios.clinicaestudiantes.dto.MascotaDTO;
import com.springejercicios.clinicaestudiantes.model.Mascota;
import com.springejercicios.clinicaestudiantes.model.Persona;
import com.springejercicios.clinicaestudiantes.service.InMascotaService;
import com.springejercicios.clinicaestudiantes.service.InPersonaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeterinariaController {
    
    @Autowired
    private InMascotaService mascoServ;
    @Autowired
    private InPersonaService persoServ;
    
    @PostMapping("/mascota/crear")
    public String createMascota(@RequestBody Mascota m){
        mascoServ.saveMascota(m);
        return "La mascota" + m.getNombre() + " fue creada con éxito";
    }
    
    @GetMapping("/mascota/traer/{id}")
    public Mascota getMascota(@PathVariable Long id){
        return mascoServ.getMascota(id);
    }
    
    @PutMapping("/mascota/editar/{id}")
    public Mascota editMascota(@PathVariable Long id,
            @RequestParam (required = false, name = "nombre") String nuevoNombre,
            @RequestParam (required = false, name = "especie") String nuevaEspecia,
            @RequestParam (required = false, name = "raza") String nuevaRaza,
            @RequestParam (required = false, name = "color") String nuevoColor,
            @RequestParam (required = false, name = "persona") Persona nuevaPersona){
        mascoServ.editMascota(id, nuevoNombre, nuevaEspecia, nuevaRaza, nuevoColor, nuevaPersona);
        return getMascota(id);
    }
    
    @DeleteMapping("/mascota/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        String nombre = getMascota(id).getNombre();
        mascoServ.deleteMascota(id);
        return nombre + " fue borrado.";
    }
    
    @GetMapping("/mascota/caniches")
    public List<Mascota> getCaniches(){
        return mascoServ.getCaniches();
    }
    
    @GetMapping("/mascota/dto")
    public List<MascotaDTO> getMascotaDTO(){
        List<MascotaDTO> lista = new ArrayList<>();
        for (Mascota m : mascoServ.getMascotas()) {
            lista.add(generarDto(m));
        }
        return lista;
    }
    
    private MascotaDTO generarDto(Mascota m){
        Long id_Persona = m.getResponsable().getId();
        return new MascotaDTO(m.getNombre(), m.getEspecie(), m.getRaza(), persoServ.getPersona(id_Persona).getNombre(), persoServ.getPersona(id_Persona).getApellido());
    }
 
}
