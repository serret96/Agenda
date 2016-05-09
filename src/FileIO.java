import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by RUBEN on 02/05/2016.
 */
public class FileIO {
     Usuari usuari = new Usuari();

    public static ArrayList<String> getIdUsuaris(String fitxer) {
        File fin = new File(fitxer);
        Scanner sc = new Scanner(fin);
        ArrayList<String> ids = new ArrayList<>();
        while(sc.hasNextLine()){
            String linia = sc.nextLine();
            ids.add(linia.split(";")[1]);
        }
         return ids;
    }

    public static Usuari getUsuari(String fitxer, String idUsuari) {
        File fin = new File(fitxer);
        return;
    }

    public static ArrayList<Usuari> getUsuaris(String fitxer) {
        File fin = new File(fitxer);
        Scanner sc = new Scanner(fin);
        ArrayList<String> usuaris = new ArrayList<>();
        while(sc.hasNextLine()){
            String linia = sc.nextLine();
            String[] u = linia.split(";");
            Usuari user = new Usuari(u[0], u[1], u[2], u[3], u[4], u[5]);
            usuaris.add(user);
        }
        return Usuari;
    }

    public static boolean guardarUsuari(String fitxer, Usuari usuari) {
        File fin = new File(fitxer);
        return resultatguardat();
    }

    public static boolean borrarUsuari(String fitxer, String idUsuari) {
        File fin = new File(fitxer);
        return resultatborrat();
    }
    public static boolean resultatguardat(){
    boolean resultat = true;


    return resultat;
}
    public static boolean resultatborrat(){
     boolean resultat = true;

        return resultat;
    }
}
