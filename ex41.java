
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ex41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digues el usuari: ");
        String usuari = in.nextLine();
        System.out.println("Digues la contrasenya: ");
        String pass = in.nextLine();
        File f = new File(usuari + ".usr");
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                UserEx41 u = (UserEx41) ois.readObject();
                System.out.println(u.password.equals(pass) ? "Correcte" : "Contrasenya incorrecta");
            } catch (Exception e) {
                System.out.println("Error.");
            }
        } else {
            System.out.print("T'has de reguistrar. Digues si vols reguistrar-te: si o no.");
            if (in.nextLine().equalsIgnoreCase("si")) {
                try {
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(new UserEx41(usuari, pass));
                    System.out.println("Ya estàs registrat.");
                } catch (Exception e) {
                    System.out.println("Error.");
                }
            }
        }
    }
}