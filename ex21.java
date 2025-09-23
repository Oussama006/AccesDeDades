import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ex21{
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        Scanner in = new Scanner(System.in);
        System.out.print("Introdueix el nom del fitxer: ");
        String nomFitxer = in.nextLine();
        int contador = 0;

        File f = new File(nomFitxer);
        FileInputStream fis = new FileInputStream(f);

            int n;
            while ((n = fis.read())!= -1) {
                char c = (char) n;
                if(c == 'a'){
                    contador++;
                }
            }
            fis.close();
            System.out.println("El nombre de vegades que apareix la lletra 'a' en el fitxer és: " + contador);
            in.close();
    }
}