
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Introdueix el usuari: ");
        String usuari = in.nextLine();
        System.out.println("Introdueix la contraseña: ");
        int contraseña = in.nextInt();

        //File f = new File("users.txt");
        //String text = "user1#1234";

        /*     if (f.exists()) {
            try {
                FileOutputStream fis = new FileOutputStream(f);
                String [] parts = text.split("#");
                parts[0] = text;
                parts[1] = text;

                String usu = parts[0];
                String cont = parts[1];

                System.out.println("Usuari: " + usu + "\n" + "Contraseña: " + cont);


            } catch (Exception e) {

            }
        }*/
    }
}
