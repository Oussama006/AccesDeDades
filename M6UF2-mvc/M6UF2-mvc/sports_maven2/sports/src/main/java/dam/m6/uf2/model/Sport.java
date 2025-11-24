package dam.m6.uf2.model;

public class Sport {
    private int cod;
    private String nombre;

    public Sport() {
    }

    public Sport(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public Sport(String nombre) {
        this.nombre = nombre;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
