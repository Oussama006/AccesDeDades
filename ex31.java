import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class ex31{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);

        int aleatori =(int)(Math.random()*3+1);
        String fitxer = "secret.bin";

        FileOutputStream fos = new FileOutputStream(fitxer);
        DataOutputStream dos = new DataOutputStream(fos);

        int codi = aleatori;
        for(int i= 0; i < 10; i++){
            StringBuilder secret = new StringBuilder();
            for(int j = 0; j < 3; j++){
                char letra = (char)('A' + (int)(Math.random() * 26));
                secret.append(letra);
            }
            dos.writeInt(codi);
            dos.writeChars(secret.toString());

            System.out.println(codi + ": " + secret);

            codi = codi + aleatori;

        }
        dos.close();
        System.out.println("S'ha creat el fitxer " + fitxer);

    }
}