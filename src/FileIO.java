import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by RUBEN on 02/05/2016.
 */
public class FileIO {

    public static ArrayList<String> getIdUsuaris(String fitxer) {
        ArrayList<String> ids = new ArrayList<>();
        try {
            File fin = new File(fitxer);
            Scanner sc = new Scanner(fin);


            while (sc.hasNextLine()) {
                String linia = sc.nextLine();
                ids.add(linia.split(";")[1]);
            }
            sc.close();
        }

        catch (Exception e){
            Biblioteca.imprimirln("Error: " + e);
        }

         return ids;
    }

    public static ArrayList<Usuari> getUsuaris(String fitxer) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        try{

            File fin = new File(fitxer);

            Biblioteca.imprimirln(fin.getAbsolutePath());
            Scanner sc = new Scanner(fin);

            while(sc.hasNextLine()) {
                String linia = sc.nextLine();
                String[] u = linia.split(";");
                boolean valid = u[0].equals("true");
                Usuari user = new Usuari(valid, u[1], u[2], u[3], u[4], u[5]);
                usuaris.add(user);
            }
            sc.close();
        }
        catch (Exception e){
            Biblioteca.imprimirln("Error: " + e);
        }
        return usuaris;
    }

    public static boolean guardarUsuaris (String fitxer, ArrayList<Usuari> usuaris) {
        try {
            File fin = new File(fitxer);
            PrintStream escriure = new PrintStream(fitxer);
            String usuari;
            for (Usuari u : usuaris) {
                usuari = u.getValid() + ";" + u.getId() + ";" + u.getContrasenya() + ";" + u.getNom() + ";" + u.getCognoms() + ";" + u.getEmail();
                escriure.println(usuari);
            }
        } catch (Exception e) {
            Biblioteca.imprimirln("Error :" + e);
            return false;
        }

        return true;
    }
}
