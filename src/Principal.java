import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Oscar on 02/05/2016.
 */

public class Principal {
	//private final String AGENDA = "../../../dades/agenda.txt";		// Ruta del fitxer on es guarda l'agenda
	private final String AGENDA = "dades/agenda.txt";		// Ruta del fitxer on es guarda l'agenda
	private ArrayList<Usuari> usuaris;							// Array amb els usuaris de l'agenda

    public static void main(String[] args) {
        new Principal().inici();
    }

	/* CONSTRUCTOR */
	public Principal() {
		/* Carregar des del fitxer els usuaris */
		usuaris = FileIO.getUsuaris(AGENDA);
	}

    public void inici() {
        String[] opcionsMenu = {
				"Inserir usuari",
				"Consultar usuari",
				"Mostrar usuaris",			// Mostra nomes usuaris valids. Camps: Nom, Cognoms, email
				"Modificar usuari",
				"Borrar usuari",
				"Sortir"
		};
		final int EXIT_OPTION = opcionsMenu.length;

		int opcio = -1;
		while (opcio != EXIT_OPTION) {
			opcio = Biblioteca.menu(opcionsMenu, "Escull una opció: ");
			switch (opcio) {
				case 1:
					inserirUsuari();
					break;
				case 2:
					consultarUsuari();
					break;
				case 3:
					mostrarUsuaris();
					break;
				case 4:
					modificarUsuari();
					break;
				case 5:
					eliminarUsuari();
					break;
			}

			if (opcio != EXIT_OPTION) pause();
			else exit();
		}
    }

	/**
	 * Insereix un usuari a l'agenda
	 */
	private void inserirUsuari() {
		String nom, cognom, email;

		/* Demanar dades a l'usuari */
		do {
			do {
				nom = Biblioteca.llegirLinia("Nom: ");
				if (nom.indexOf(';') != -1)
					Biblioteca.imprimirln("No pot contenir el caracter ';'");
			} while (nom.indexOf(';') != -1);

			do {
				cognom = Biblioteca.llegirLinia("Cognoms: ");
				if (cognom.indexOf(';') != -1)
					Biblioteca.imprimirln("No pot contenir el caracter ';'");
			} while (cognom.indexOf(';') != -1);

			if (nom.equals("") && cognom.equals(""))
				Biblioteca.imprimirln("El nom i cognom no poden estar els dos en blanc.");

		} while (nom.equals("") && cognom.equals(""));

		do {
			email = Biblioteca.llegirLinia("Email: ");
			if (email.indexOf(';') != -1)
				Biblioteca.imprimirln("No pot contenir el caracter ';'");
		} while (email.indexOf(';') != -1);

		String idUsuari = generarIdUsuari(nom, cognom);
		String contrasenya = generarContrasenya();

		Biblioteca.imprimirln("Id usuari:   " + idUsuari);
		Biblioteca.imprimirln("Contrasenya: " + contrasenya);

		Usuari newUser = new Usuari(true, idUsuari, contrasenya, nom, cognom, email);
		usuaris.add(newUser);
	}

	private void consultarUsuari() {
		String busqueda = Biblioteca.llegirLinia("Buscar: ");
		busqueda = busqueda.trim();
		ArrayList<Usuari> coincidencies = new ArrayList<>();
		for (Usuari u : usuaris) {
			if (u.getValid()) {
				if (busqueda.equalsIgnoreCase(u.getId()) ||
					busqueda.equalsIgnoreCase(u.getNom()) ||
					busqueda.equalsIgnoreCase(u.getCognoms()) ||
					busqueda.equalsIgnoreCase(u.getEmail())) {
					coincidencies.add(u);
				}
			}
		}

		if (coincidencies.size() == 0) {
			Biblioteca.imprimirln("No s'han trobat coincidencies.");
			return;
		}

		String[] escollirUsuari = new String[coincidencies.size()];
		Usuari u;
		for (int i = 0; i < escollirUsuari.length; i++) {
			u = coincidencies.get(i);
			escollirUsuari[i] = u.getId() + " - " + u.getNom() + " " + u.getCognoms();
		}
		int opcio = Biblioteca.menu(escollirUsuari, "Escollir un usuari: ");
		u = coincidencies.get(opcio-1);

		consultarUsuari(u);
	}

	private void consultarUsuari(Usuari u) {
		String[] titols = {"Id", "Contrasenya", "Nom", "Email"};
		String[][] contingut = new String[1][titols.length];

		contingut[0][0] = u.getId();
		contingut[0][1] = u.getContrasenya();
		contingut[0][2] = (u.getNom() + " " + u.getCognoms()).trim();
		contingut[0][3] = u.getEmail();

		Biblioteca.imprimirTaula(titols, contingut);
	}

	private void mostrarUsuaris() {
		if (usuaris.size() == 0) {
			Biblioteca.imprimirln("No hi ha usuaris.");
			return;
		}
		String[] titols = {"Id", "Nom", "Email"};
		String[][] contingut = new String[usuaris.size()][titols.length];
		Usuari user;
		for (int i = 0; i < usuaris.size(); i++) {
			user = usuaris.get(i);
			if (user.getValid()) {
				contingut[i][0] = user.getId();
				contingut[i][1] = (user.getNom() + " " + user.getCognoms()).trim();
				contingut[i][2] = user.getEmail();
			}
		}
		Biblioteca.imprimirTaula(titols, contingut);
	}

	private void modificarUsuari() {

	}

	private void eliminarUsuari() {

	}

	private void pause() {
		Scanner sc = new Scanner(System.in);
		Biblioteca.imprimir("Prèmer enter <-' per continuar...");
		sc.nextLine();
	}

	private void exit() {
		FileIO.guardarUsuaris(AGENDA, usuaris);
		System.exit(0);
	}

	private ArrayList<String> getIdUsuaris() {
		ArrayList<String> ids = new ArrayList<>();
		for (Usuari u : usuaris) {
			ids.add(u.getId());
		}
		return ids;
	}

	private String generarIdUsuari(String nom, String cognoms) {
		/* Validar arguments */
		if (nom == null) nom = "";
		if (cognoms == null) cognoms = "";

		nom = nom.trim().toLowerCase();
		cognoms = cognoms.trim().toLowerCase();

		if (nom.equals("") && cognoms.equals(""))
			return null;

		/* Extreure 1r cognom */
		String cognom = cognoms;
		int posEspai = cognoms.indexOf(' ');
		if (posEspai != -1)
			cognom = cognoms.substring(0, posEspai);

		/* Generar id d'usuari */
		String idUsuari = "";

		if (!nom.equals("") && !cognoms.equals("")) {
			// Si hi ha nom i cognoms: id = 1a lletra nom + 1r cognom
			idUsuari += nom.charAt(0) + cognom;
		} else if (!nom.equals("")) {
			// Si només hi ha el nom: id = nom
			idUsuari = nom;
		} else {
			// Si només hi ha el cognom: id = 1r cognom
			idUsuari = cognoms;
		}
		idUsuari += "1";

		ArrayList<String> idUsuaris = getIdUsuaris();
		boolean idCorrecte = (idUsuaris.size() == 0);

		int n = 2;		// Número d'idUsuari
		int k = 1;		// Xifres de 'n';
		int y = 10;		// Auxiliar per actualitzar 'k'
		int i = 0;
		while (!idCorrecte) {
			if (idUsuari.equals(idUsuaris.get(i))) {
				idUsuari = idUsuari.substring(0, idUsuari.length()-k);
				idUsuari += n;
				n++;
				if (n > y) {
					k++;
					y *= 10;
				}
				i = 0;
			}
			i++;
			if (i == idUsuaris.size()) idCorrecte = true;
		}
		return idUsuari;
	}

	private String generarContrasenya() {
		final int NUM_DIGITS = 8;
		final String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		char c;
		int maj = 0, min = 0, num = 0;

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


