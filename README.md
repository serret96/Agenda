# Programa Agenda

# Teoria
####Anàlisi

####Disseny
  - Disseny funcional
  - Disseny interficies
  - Disseny estructura
    - Dades
    - Funcions
    - Interficie
    
####Implementació
  - Implementacio
  - Proves
  - Integrar
  - Provar

# Conceptes del programa

#Biblioteca:
* public static int menu(String[] opcions, String missatgeEscollirOpcio);
* public static int llegirEnter(String missatge);
* public static String llegirLinia(String missatge);
* public static void imprimir(String text);
* public static void imprimirln();	// Imprimeix un salt de línia
* public static void imprimirln(String text);

###FileIO:
* public static String[] getIdUsuaris(String fitxer);
* public static Usuari getUsuari(String fitxer, String idUsuari);
* public static Usuari[] getUsuaris(String fitxer);
* public static boolean guardarUsuari(String fitxer, Usuari usuari); //Si existeix, modificar-lo, sinó, guardar-lo en una línia nova. ‘true’ si s’ha pogut fer, ‘false’ en cas contrari.
* public static boolean borrarUsuari(String fitxer, String idUsuari);  // ‘true’ si s’ha pogut borrar o ‘false’ en cas contrari

###Usuari:
Atributs (variables):
* private boolean valid;
* private String id;
* private String contrasenya;
* private String nom;
* private String cognoms;
* private String email;
######Constructors:
* public Usuari (boolean valid, String id, String contrasenya, String nom, String cognoms, String email);
	* public Usuari (String nom, String cognoms, String email);
/** La resta d’atributs s’hauran d’inicialtzar en el constructor
(valid = true; id = generarId(); contrasenya = generarContrasenya();)*///
#####Mètodes:
	implementar getters i setters publics per a tots els atributs.

##Disseny Funcional
