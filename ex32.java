import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ex32{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner in = new Scanner(System.in);

        System.out.println("Introdueix el codi per buscar: ");
        int codi = in.nextInt();

        String fitxer = "secret.bin";
        FileInputStream fis = new FileInputStream(fitxer);
        DataInputStream dis = new DataInputStream(fis);

        boolean trobat = true;

        while(dis.available() > 0){
            int PrimCodi = dis.readInt();
            char primer = dis.readChar();
            char segon = dis.readChar();
            char tercer = dis.readChar();
            
            if (PrimCodi == codi) {
                System.out.println("Secret trobat: " + primer + segon + tercer);
                trobat = false;
                return;
            }
        }

        if (!trobat) {
            System.out.println("El codi no s'ha trobat.");
        }
        dis.close();
    }
}