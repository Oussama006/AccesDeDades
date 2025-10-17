package adivinaJugador.model;

import java.io.Serializable;

public class User implements Serializable{

    static String puntitos;
    private String nom;
    private String usuari; 
    private int contrasenya;
    private int puntos;

    public User(String nom, String usuari, int puntos) {
        this.nom = nom;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
        this.puntos = 0;
    }

    public String getNom() {
        return nom;
    }

    public String getUsuari(){
        return usuari;
    }

    public int getContra(){
        return contrasenya;
    }

    public void puntitos(int punto){
        puntos += punto;
    }
}