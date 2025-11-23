
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Examen_Oussama {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.println("Introdueix el usuari: ");
        String usuari = in.nextLine();
        System.out.println("Introdueix la contraseña: ");
        String pass = in.nextLine();

        File f = new File("users.txt");
        boolean trobat = false;
        BufferedReader br = null;

        if (f.exists()) {
            try {
                br = new BufferedReader(new FileReader(f));
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] parts = linea.split("#");
                    if (parts[0].equals(usuari)) {
                        trobat = true;
                        if (parts[1].equals(pass)) {
                            System.out.println("Acces correcte.");
                        } else {
                            System.out.println("Contraseña incorrecte");
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error llegint el fitxer");
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    // TODO: handle exception

                }
            }
        }
        if (!trobat) {
            System.out.print("No existeix. Vols reguistrar-te: si o no.");
            if (in.nextLine().equalsIgnoreCase("si")) {
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(f, true));
                    bw.write(usuari + "#" + pass);
                    bw.newLine();
                    System.out.println("Registrat correctament!");
                } catch (Exception e) {
                    System.out.println("Error escrivint el fitxer");
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }

        String fitxer = "shop.bin";
        FileOutputStream fos = new FileOutputStream(fitxer);
        DataOutputStream dos = new DataOutputStream(fos);
        int codi = 0;

    }

    public static String dataActual() {
        LocalDate today = LocalDate.now();
        return today.toString();
    }
}
