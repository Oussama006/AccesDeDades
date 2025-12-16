package dam.m6.uf2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deportistas")
public class Deportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "cod_deporte")
    private Sport sport;

    public Deportista() {
    }

    public Deportista(String nombre, Sport sport) {
        this.nombre = nombre;
        this.sport = sport;
    }

    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public Sport getSport() {
        return sport;
    }
}
