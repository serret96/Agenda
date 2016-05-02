/**
 * Created by Oscar on 02/05/2016.
 */

public class Principal {
    public static void main(String[] args) {
        new Principal().inici();
    }

    public void inici() {
        String[] opcionsMenu = {
				"Inserir usuari",
				"Consultar usuari",
				"Mostrar usuaris",			// Mostra nomes usuaris valids. Camps: Nom, Cognoms, email
				"Modificar usuari",
				"Borrar usuari"
		};
    }
}


