package dam.m6.uf2;

public class Deporte{
    private int cod;
    private String name;

    public Deporte(int cod, String name){
        this.cod = cod;
        this.name = name;
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

    @Override
    public String toString() {
        return "Deporte [cod=" + cod + ", name=" + name + "]";
    }

}