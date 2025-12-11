package com.example.futbol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.futbol.Entity.Jugador;

public interface JugadoresRepository extends JpaRepository<Jugador, String>{
    
    List<Jugador> findByEquipoId(int equipoId);
}
