
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SaveText {

    private static int count;
    public static void main(String[] args)  throws IOException {
        
        Scanner in = new Scanner(System.in);
        String file = "usertext.txt";

        File f = new File(file);

        FileOutputStream fos = new FileOutputStream(f);
        System.out.println("Escriu un text per guardar al fitxer: ");
        fos.write(in.nextLine().getBytes());
        fos.write("\n".getBytes());

            String b[];
            
            for(char c : t.toCharArray()){
                    fos.write(c);
                }

            fos.close();

            
            FileInputStream fis = new FileInputStream(f);

            int n =0;
            while (n!=-1) {
                n=fis.read();
                System.out.print((char)n);
            }

    }

}