package com.example.futbol.Entity;

import static java.util.UUID.randomUUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="jugadores")
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private int dorsal;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String posicion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="equipo_id", nullable= false)
    private Equipo equipo;

    public Jugador(){
    }
    
    public Jugador(String id,int dorsal, String nombre, String apellido1, 
        String apellido2, String posicion, Equipo equipo){
            this.id = randomUUID().toString();
            this.dorsal= dorsal;
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            this.posicion = posicion;
            this.equipo = equipo;
        }


        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }

        public int getDorsal(){
            return dorsal;
        }

        public void setDorsal(int dorsal){
            this.dorsal = dorsal;
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

        public String setPosicion(){
            return posicion;
        }

        public void getPosicion(String posicion){
            this.posicion = posicion;
        }

        public Equipo getEquipo(){
            return equipo;
        }

        public void setEquipo(Equipo equipo){
            this.equipo = equipo;
        }
}

