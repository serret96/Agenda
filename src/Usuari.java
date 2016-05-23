import java.util.Random;

/**
 * Programa:	Agenda
 *
 * Autors:		Ruben Serret, Jesús López, Jose Febrer, Oscar Oliver
 * Professor:	Carles Añó
 * Data final:	30/05/2016
 * Data inici:	02/05/2016
 * Versió:		1.03
 */
public class Usuari {

    /* ---------- VARIABLES ----------- */
    private boolean valid;          //Variable per a saber si un usuari es valid o no
    private String id;              //Variable que guarda la id dels usuaris
    private String contrasenya;     //Variable que guarda la contrasenya dels usuaris
    private String nom;             //Variable que guarda el nom dels usuaris
    private String cognoms;         //Variable que guarda el cognom dels usuaris
    private String email;           //Variable que guarda el correu dels usuaris


    /* ---------- CONSTRUCTORS ----------- */
    public Usuari (boolean Valorvalid, String Valorid, String Valorcontrasenya, String Valornom, String Valorcognoms, String Valoremail){
        valid = Valorvalid;
        id = Valorid;
        contrasenya = Valorcontrasenya;
        nom = Valornom;
        cognoms = Valorcognoms;
        email = Valoremail;
    }

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

    /** Funció que genera una contrasenya aleatoria amb com a
     * mínim 1 majúscula, 1 minúscula i 1 número */
    public static String generarContrasenya() {
        Random r = new Random();
        String contrasenya;
        int k = r.nextInt(2);
        switch (k) {
            case 0:
                contrasenya = generarContrasenya1();
                break;
            default:
                contrasenya = generarContrasenya2();
                break;
        }
        return contrasenya;

    }

    /** Funció que genera una contrasenya aleatoria amb com a mínim 1 majúscula, 1 minúscula i 1 número */
    private static String generarContrasenya1(){
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
        while(!trobar_num || !trobar_min || !trobar_maj){
            for(int i =0; i<8; i++){
                int randomNum = 0 + (int)(Math.random() * 3);

                if(randomNum==0){   // Generació d'un número aleatori
                    int numero = 0 + (int)(Math.random() * 9);
                    pass[i] = Integer.toString(numero);
                    trobar_num=true;
                }
                if(randomNum==1){   //Generació d'una minúscula aleatoria
                    int random_minuscula = 1 + (int)(Math.random() * minuscula.length-1);
                    pass[i] = minuscula[random_minuscula];
                    trobar_min=true;
                }
                if(randomNum==2){   //Generació d'una majúscula aleatoria
                    int random_majuscula = 1 + (int)(Math.random() * majuscula.length-1);
                    pass[i]= majuscula[random_majuscula];
                    trobar_maj=true;
                }
            }
        }
        for(int i = 0; i<8; i++){
            contrasenya+=pass[i];
        }
        return contrasenya;
    }

    /**
     * Genera una contrasenya aleatoria
     * @return una contrasenya
     */
    private static String generarContrasenya2() {
        final int NUM_DIGITS = 8;
        // values: caràcters amb els quals ha d'estar formada la contrasenya
        final String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int maj = 0, min = 0, num = 0;	// Comptadors de majúscules, minúscules i números
        char c;

        String contrasenya;
        Random r = new Random();

        do {
            contrasenya = "";
            for (int i = 0; i < NUM_DIGITS; i++) {
                c = values.charAt(r.nextInt(values.length()));
                if		(c >= 'A' && c <= 'Z') maj++;
                else if (c >= 'a' && c <= 'z') min++;
                else if (c >= '0' && c <= '9') num++;
                contrasenya += c;
            }
        } while (maj == 0 || min == 0 || num == 0);

        return contrasenya;
    }

}
