package com.example.futbol.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbol.Entity.Arbitro;
import com.example.futbol.Repository.ArbitroRepository;



@RestController
@RequestMapping("arbitros")
public class ArbitroController {
    
    private final ArbitroRepository arbitroRepository;


    public ArbitroController(ArbitroRepository arbitroRepository
){
            this.arbitroRepository = arbitroRepository;

        }

    @GetMapping
    public ResponseEntity <List<Arbitro>> getAll() {
        return ResponseEntity.ok(arbitroRepository.findAll());
    }

    @PostMapping
    public ResponseEntity addArbitro(@RequestBody Arbitro arbitro) {
        //TODO: process POST request
        
        return ResponseEntity.ok(arbitroRepository.save(arbitro));
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarArbitro(@PathVariable String id){
        arbitroRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
