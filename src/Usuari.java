/**
 * Created by RUBEN on 02/05/2016.
 */
public class Usuari {
    private static boolean valid;
    private static String id;
    private static String contrasenya;
    private static String nom;
    private static String cognoms;
    private static String email;

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
    //private String generarContrasenya();

}
