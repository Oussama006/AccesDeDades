
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class prova2 {

    private static int count;
    public static void main(String[] args)  throws IOException {
        
        String file = "text.txt";

        File f = new File(file);

        FileOutputStream fos = new FileOutputStream(f);
        
        fos.write("Holla weshhhh".getBytes());
        fos.write("\n".getBytes());

            String t = "Hallo wie gehts";
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