package dam.m6.uf2;


public class Deportista{
    
    private int cod;
    private String name;
    private int cod_deporte;

    public Deportista(int cod, String name, int cod_deporte) {
        this.cod = cod;
        this.name = name;
        this.cod_deporte = cod_deporte;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod_deporte() {
        return cod_deporte;
    }

    public void setCod_deporte(int cod_deporte) {
        this.cod_deporte = cod_deporte;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deportista{");
        sb.append("cod=").append(cod);
        sb.append(", name=").append(name);
        sb.append(", cod_deporte=").append(cod_deporte);
        sb.append('}');
        return sb.toString();
    }



}