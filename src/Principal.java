import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Oscar on 02/05/2016.
 */

public class Principal {
	private final String AGENDA = "../dades/agenda.txt";		// Ruta del fitxer on es guarda l'agenda
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
		String nom = Biblioteca.llegirLinia("Nom: ");
		String cognom = Biblioteca.llegirLinia("Cognoms: ");
		String email = Biblioteca.llegirLinia("Email: ");
		String idUsuari = "" + nom.charAt(0);
		idUsuari += cognom.substring(0, cognom.indexOf(' '));
		idUsuari += 1;
		ArrayList<String> idUsuaris = FileIO.getIdUsuaris(AGENDA);
		boolean idCorrecte = false;
		int i = 0, n = 2;
		while (!idCorrecte) {
			if (idUsuari.equals(idUsuaris.get(i))) {
				idUsuari += idUsuari.substring(0, idUsuari.length()-1);
				idUsuari += n;
				n++;
				i = 0;
			}
			i++;
			if (i == idUsuari.length()) idCorrecte = true;
		}
		Usuari newUser = new Usuari(idUsuari, nom, cognom, email);
		usuaris.add(newUser);
	}

	private void consultarUsuari() {
		String busqueda = Biblioteca.llegirLinia("Buscar: ");

	}

	private void mostrarUsuaris() {
		String[] titols = {"Id", "Nom", "Email"};
		String[][] contingut = new String[usuaris.size()][titols.length];
		Usuari user;
		for (int i = 0; i < usuaris.size(); i++) {
			user = usuaris.get(i);
			contingut[i][0] = user.getId();
			contingut[i][1] = user.getNom() + " " + user.getCognoms();
			contingut[i][2] = user.getEmail();
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
}


