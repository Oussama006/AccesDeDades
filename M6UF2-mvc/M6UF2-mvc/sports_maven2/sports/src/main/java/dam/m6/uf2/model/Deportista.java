package dam.m6.uf2.model;

public class Deportista {

    private int id;
    private String name;
    private int codDeporte;

    public Deportista(int id, String name, int codDeporte) {
        this.id = id;
        this.name = name;
        this.codDeporte = codDeporte;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCodDeporte() {
        return codDeporte;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (sport " + codDeporte + ")";
    }
}
