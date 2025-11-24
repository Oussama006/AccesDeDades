package dam.m6.uf2.model;

public class Deportista {

    private int cod;
    private String nombre;
    private int codDeporte;
    private String deporte; 

    public Deportista(String nombre, int cod) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public Deportista(int cod, String nombre, String deporte) {
        this.cod = cod;
        this.nombre = nombre;
        this.deporte = deporte;
    }

    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodDeporte() {
        return codDeporte;
    }

    public String getDeporte() {
        return deporte;
    }
}
