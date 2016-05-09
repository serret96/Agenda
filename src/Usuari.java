/**
 * Created by RUBEN on 02/05/2016.
 */
public class Usuari {
    private boolean valid;
    private String id;
    private String contrasenya;
    private String nom;
    private String cognoms;
    private String email;

    public boolean getValid(){return valid;}
    public String getId(){return id;}
    public String getContrasenya(){return contrasenya;}
    public String getNom(){return nom;}
    public String getCognoms(){return cognoms;}
    public String getEmail(){return email;}
    public void setValid(boolean valid){valid = getValid();}
    public void setId(String id){id = getId();}
    public void setContrasenya(String contrasenya){contrasenya = getContrasenya();}
    public void setNom(String nom){nom = getNom();}
    public void setCognoms(String cognoms){cognoms = getCognoms();}
    public void setEmail(String email){email = getEmail();}
    //private String generarContrasenya();

}
