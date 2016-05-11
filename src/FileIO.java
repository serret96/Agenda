import java.io.File;
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
            Biblioteca.imprimir("No s'ha trobat cap document");
        }

         return ids;
    }

    public static Usuari getUsuari(String fitxer, String idUsuari) {
        File fin = new File(fitxer);
        return null;
    }

    public static ArrayList<Usuari> getUsuaris(String fitxer) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        try{

            File fin = new File(fitxer);
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
            Biblioteca.imprimir("No s'ha trobat cap document");
        }
        return usuaris;
    }

    public static boolean guardarUsuaris (String fitxer, ArrayList<Usuari> usuaris) {
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
