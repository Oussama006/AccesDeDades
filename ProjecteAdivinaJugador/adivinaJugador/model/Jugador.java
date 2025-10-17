package adivinaJugador.model;

import java.util.List;

public class Jugador{
    private int id;
    private String nombre;
    private int puntos;
    private List<String> pistas;
    
    public Jugador(int id, String nombre, int puntos, List<String> pistas){
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
        this.pistas = pistas;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPunts(){
        return puntos;
    }

    public List<String> getPistas(){
        return pistas;
    }
}