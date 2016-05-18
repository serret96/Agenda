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
    private String generarContrasenya(){
        String [] pass = new String [8];
        String[] minuscula = {
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"
        };
        String[] majuscula={
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
        };
        boolean trobar_num=false;
        boolean trobar_min=false;
        boolean trobar_maj=false;
        String contrasenya = "";
        for(int i =0; i<8; i++){
            int randomNum = 0 + (int)(Math.random() * 3);

            if(randomNum==0){
                int numero = 0 + (int)(Math.random() * 9);
                pass[i] = Integer.toString(numero);
            }
            if(randomNum==1){
                int random_minuscula = 1 + (int)(Math.random() * minuscula.length-1);
                pass[i] = minuscula[random_minuscula];
            }
            if(randomNum==2){
                int random_majuscula = 1 + (int)(Math.random() * majuscula.length-1);
                pass[i]= majuscula[random_majuscula];
            }
        }
        for(int i = 0; i<8; i++){
            if(pass[i].charAt(0)>=48 && pass[i].charAt(0) <= 57){
                trobar_num=true;
            }
            if(pass[i].charAt(0)>=97 && pass[i].charAt(0) <= 122){
                trobar_min=true;
            }
            if(pass[i].charAt(0)>=65 && pass[i].charAt(0) <= 90){
                trobar_maj=true;
            }
        }
        if(!trobar_num){
            int random_num = 0 + (int)(Math.random() * 9);
            int random_pos = 0 + (int)(Math.random() * 8);
            pass[random_pos] = Integer.toString(random_num);
        }
        if(!trobar_min){
            int random_pos = 0 + (int)(Math.random() * 8);
            int random_minuscula = 1 + (int)(Math.random() * minuscula.length-1);
            pass[random_pos] = minuscula[random_minuscula];
        }
        if(!trobar_maj){
            int random_pos = 0 + (int)(Math.random() * 8);
            int random_majuscula = 1 + (int)(Math.random() * majuscula.length-1);
            pass[random_pos] = majuscula[random_majuscula];

        }
        for(int i = 0; i<8; i++){
            contrasenya+=pass[i];
        }
        return contrasenya;
    }

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
        valid=true;
        contrasenya=generarContrasenya();
    }
    //Ruben tard

}
