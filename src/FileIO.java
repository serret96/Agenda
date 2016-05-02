/**
 * Created by RUBEN on 02/05/2016.
 */
public class FileIO {

    public static String[] getIdUsuaris(String fitxer);
    public static Usuari getUsuari(String fitxer, String idUsuari);
    public static Usuari[] getUsuaris(String fitxer);
    public static boolean guardarUsuari(String fitxer, Usuari usuari);
    public static boolean borrarUsuari(String fitxer, String idUsuari);

}
