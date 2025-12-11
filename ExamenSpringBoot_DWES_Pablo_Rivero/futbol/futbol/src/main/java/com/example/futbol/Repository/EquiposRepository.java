package com.example.futbol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.futbol.Entity.Equipo;

public interface EquiposRepository extends JpaRepository<Equipo, Integer>{
    
}
