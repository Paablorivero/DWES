package com.example.futbol.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbol.Entity.Equipo;
import com.example.futbol.Entity.Jugador;
import com.example.futbol.Repository.EquiposRepository;
import com.example.futbol.Repository.JugadoresRepository;

@RestController
@RequestMapping("/jugadores")
public class JugadoresController {
    
    private final EquiposRepository equiposRepository;
    private final JugadoresRepository jugadoresRepository;

    public JugadoresController(EquiposRepository equiposRepository,
        JugadoresRepository jugadoresRepository){
            this.equiposRepository = equiposRepository;
            this.jugadoresRepository = jugadoresRepository;
        }

    @GetMapping
    public ResponseEntity<List<Jugador>> getJugadores() {
        return ResponseEntity.ok(jugadoresRepository.findAll());
    }
    
    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<List<Jugador>> getByEquipo(@PathVariable int equipoId) {

        
        List<Jugador> jugadores = jugadoresRepository.findByEquipoId(equipoId);
        return ResponseEntity.ok(jugadores);
    }
    
    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
        //TODO: process POST request
        
        int equipoId = jugador.getEquipo().getId();

        Equipo equipo = equiposRepository.findById(equipoId).orElse(null);

        if (equipo == null){
            return ResponseEntity.badRequest().build();
        }

        jugador.setEquipo(equipo);
        Jugador jugadorGuardado = jugadoresRepository.save(jugador);

        URI location = URI.create("/jugadores" + jugadorGuardado.getId());
        return ResponseEntity.created(location).body(jugadorGuardado);
    }
    
}

