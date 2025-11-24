package dam.m6.uf2;

public class Controller {

    public static void main(String[] args) {
        System.out.println("Directorio actual: " + System.getProperty("user.dir"));
        System.out.println("Iniciando SportsManager...\n");

        SportsManager.main(args);
    }
}
