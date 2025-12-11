package com.example.futbol.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Arbitros")
public class Arbitro {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String rol;

    public Arbitro(){
    }

    public Arbitro(String id, String nombre, String apellido1, String apellido2, String rol){
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.rol = rol;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido1(){
        return apellido1;
    }

    public void setApellido1(String apellido1){
        this.apellido1 = apellido1;
    }

    public String getApellido2(){
        return apellido2;
    }

    public void setApellido2(String apellido2){
        this.apellido2 = apellido2;
    }

    public String getRol(){
        return rol;
    }

    public void setRol(String rol){
        this.rol = rol;
    }
}
