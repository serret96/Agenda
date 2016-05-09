import java.io.File;
/**
 * Created by RUBEN on 02/05/2016.
 */
public class FileIO {

    public static String[] getIdUsuaris(String fitxer){
        File fin = new File(fitxer);

        return Usuari.id;
    }
    public static Usuari getUsuari(String fitxer, String idUsuari){
        File fin = new File(fitxer);
        return ;
    }
    public static Usuari[] getUsuaris(String fitxer){
        File fin = new File(fitxer);
        return ;
    }
    public static boolean guardarUsuari(String fitxer, Usuari usuari){
        File fin = new File(fitxer);
        boolean resultat;
        return ;
    }
    public static boolean borrarUsuari(String fitxer, String idUsuari){
        File fin = new File(fitxer);
        Boolean resultat;
        return ;

    }


}
