import java.util.Scanner;

/**
 * Created by Oscar on 02/05/2016.
 */

public class Principal {
	private String agenda = "agenda.txt";

    public static void main(String[] args) {
        new Principal().inici();
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

	private void inserirUsuari() {

	}

	private void consultarUsuari() {

	}

	private void mostrarUsuaris() {
		Usuari[] usuaris = FileIO.getUsuaris(agenda);
		String[] titols = {"Id", "Nom", "Email"};
		String[][] contingut = new String[usuaris.length][titols.length];
		for (int i = 0; i < usuaris.length; i++) {
			contingut[i][0] = usuaris[i].getId();
			contingut[i][1] = usuaris[i].getNom() + " " + usuaris[i].getCognoms();
			contingut[i][2] = usuaris[i].getEmail();
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
		System.exit(0);
	}
}


