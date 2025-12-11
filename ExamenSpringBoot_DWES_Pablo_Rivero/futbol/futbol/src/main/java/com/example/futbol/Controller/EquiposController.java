package com.example.futbol.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbol.Entity.Equipo;
import com.example.futbol.Repository.EquiposRepository;

@RestController
@RequestMapping("/equipos")
public class EquiposController {
    
    private final EquiposRepository equiposRepository;

    public EquiposController(EquiposRepository equiposRepository){
        this.equiposRepository = equiposRepository;
    }

    @GetMapping
    public ResponseEntity <List<Equipo>> getAll() {
        return ResponseEntity.ok(equiposRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo equipo) {
        //TODO: process POST request
        
        return ResponseEntity.ok(equiposRepository.save(equipo));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarNombre(
        @PathVariable int id, 
        @RequestBody String nuevoNombre) {
        //TODO: process PUT request
        
        return equiposRepository.findById(id)
        .map(dato -> {
            dato.setNombre(nuevoNombre);
            return ResponseEntity.ok(equiposRepository.save(dato));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEquipo(@PathVariable int id){
        if(!equiposRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        equiposRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
