import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by RUBEN on 02/05/2016.
 */
public class FileIO {


    public static ArrayList<Usuari> getUsuaris(String fitxer) {
        /*Serveix per extraure les dades dels usuaris*/
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
        catch (Exception e) {
            Biblioteca.imprimirln("S'ha creat el fitxer de dades");   //Misatge error en cas de que no es pugue realitzar la operacio desitjada
        }
        return usuaris;
    }

    public static boolean guardarUsuaris (String fitxer, ArrayList<Usuari> usuaris) {
        /*Serveix per poder guardar els usuaris inserits */
        try {

            File fin = new File(fitxer);
            PrintStream escriure = new PrintStream(fitxer);
            String usuari;
            for (Usuari u : usuaris) {
                usuari = u.getValid() + ";" + u.getId() + ";" + u.getContrasenya() + ";" + u.getNom() + ";" + u.getCognoms() + ";" + u.getEmail();
                escriure.println(usuari);
            }
        } catch (Exception e) {
            Biblioteca.imprimirln("Error :" + e);   // Misatge error en cas de que no es pugue realitzar la operacio desitjada
            return false;
        }

        return true;
    }
}
