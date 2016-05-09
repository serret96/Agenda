/**
 * Created by RUBEN on 02/05/2016.
 */
public class Usuari {
    /* Variables */
    private static boolean valid;
    private static String id;
    private static String contrasenya;
    private static String nom;
    private static String cognoms;
    private static String email;


    /* Mètodes */
    public boolean getValid(){return valid;}
    public String getId(){return id;}
    public String getContrasenya(){return contrasenya;}
    public String getNom(){return nom;}
    public String getCognoms(){return cognoms;}
    public String getEmail(){return email;}
    public void setValid(boolean valid){Usuari.valid = valid;}
    public void setId(String id){Usuari.id = id;}
    public void setContrasenya(String contrasenya){Usuari.contrasenya = contrasenya;}
    public void setNom(String nom){Usuari.nom = nom;}
    public void setCognoms(String cognoms){Usuari.cognoms = cognoms;}
    public void setEmail(String email){Usuari.email = email;}
    private String generarContrasenya();

    /* Constructors */
    public Usuari (boolean Valorvalid, String Valorid, String Valorcontrasenya, String Valornom, String Valorcognoms, String Valoremail){
        valid = Valorvalid;
        id = Valorid;
        contrasenya = Valorcontrasenya;
        nom = Valornom;
        cognoms = Valorcognoms;
        email = Valoremail;
    }
    public Usuari (String Valorid, String Valornom, String Valorcognoms, String Valoremail){
        id = Valorid;
        nom = Valornom;
        cognoms = Valorcognoms;
        email = Valoremail;
    }
    contrasenya = generarContrasenya();

}
