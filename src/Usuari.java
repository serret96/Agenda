/**
 * Created by TARDRUBEN on 02/05/2016.
 */
public class Usuari {
    /* ---------- VARIABLES ----------- */
    private boolean valid;
    private String id;
    private String contrasenya;
    private String nom;
    private String cognoms;
    private String email;


    /* ---------- MÈTODES ----------- */
    public boolean getValid(){return valid;}
    public String getId(){return id;}
    public String getContrasenya(){return contrasenya;}
    public String getNom(){return nom;}
    public String getCognoms(){return cognoms;}
    public String getEmail(){return email;}
    public void setValid(boolean Valorvalid){valid = Valorvalid;}
    public void setId(String Valorid){id = Valorid;}
    public void setContrasenya(String Valorcontrasenya){contrasenya = Valorcontrasenya;}
    public void setNom(String Valornom){nom = Valornom;}
    public void setCognoms(String Valorcognoms){cognoms = Valorcognoms;}
    public void setEmail(String Valoremail){email = Valoremail;}
    //private String generarContrasenya();

    /* ---------- CONSTRUCTORS ----------- */
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
    //contrasenya = generarContrasenya();

}
