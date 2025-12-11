package com.example.futbol.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "nombre_equipo")
    private String nombre;
    private String sede;

    public Equipo(){
    }

    public Equipo(String nombre_equipo, String sede){
        this.nombre = nombre_equipo;
        this.sede = sede;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getSede(){
        return sede;
    }

    public void setSede(String sede){
        this.sede = sede;
    }
    
}
