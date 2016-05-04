import java.util.Scanner;
/**
 * Created by RUBEN el gayolo on 02/05/2016.
 */
public class Biblioteca {

    /* ---------- MENÚ ---------- */

    public static int menu(String[] opcions, String missatgeEscollirOpcio) {
        int opcio;

        for (int i=0, n=1; i<opcions.length; i++, n++) {
            if (n < 10) imprimir(" ");
            imprimirln(" " + n + ". " + opcions[i]);
        }

		do {
			opcio = llegirEnter(missatgeEscollirOpcio);
		} while (opcio < 1 || opcio > opcions.length);
        return opcio;

    }

    /* ---------- FUNCIONS DE LECTURA ----------- */

    public static int llegirEnter(String missatge){

        Scanner sc = new Scanner(System.in);
        int n=0;
        boolean correcte;

        imprimir(missatge);

        do{

            correcte = sc.hasNextInt();

            if (correcte){

                n = sc.nextInt();

            }else{

                sc.nextLine();

            }
        }while(!correcte);

        return n;

    }

    public static String llegirLinia(String missatge){

        Scanner sc = new Scanner (System.in);
        String linea;

        imprimir(missatge);

        linea = sc.nextLine();

        return linea;

    }


    /* ---------- FUNCIONS D'IMPRESSIÓ ---------- */

    public static void imprimir(String text){

        System.out.print(text);

    }

    public static void imprimirln(){

        System.out.println("");

    }

    public static void imprimirln(String text){

        System.out.println(text);

    }


	public static void imprimirTaula(String[] titols, String[][] contingut) {
		imprimirTaula(titols, contingut, 3);
	}

	public static void imprimirTaula(String[] titols, String[][] contingut, int espaiEntreColumnes) {
		if (titols == null || contingut == null) {
			imprimirln("El contingut o els titols no poden ser 'null'");
			return;
		}
		if (titols.length != contingut[0].length) {
			imprimirln("El contingut no encaixa amb el numero de titols.");
			return;
		}

		int[] colMaxs = new int[titols.length];
		for (int i = 0; i < titols.length; i++) {
			colMaxs[i] = titols[i].length();
		}
		for (int i = 0; i < contingut.length; i++) {
			for (int j = 0; j < contingut[0].length; j++) {
				if (contingut[i][j].length() > colMaxs[j]) {
					colMaxs[j] = contingut[i][j].length();
				}
			}
		}

		for (int i = 0; i < colMaxs.length - 1; i++) {
			colMaxs[i] += espaiEntreColumnes;
		}
		colMaxs[colMaxs.length - 1] += 1;

		int spaces;
		imprimir(" ");
		for (int i = 0; i < titols.length; i++) {
			spaces = colMaxs[i] - titols[i].length();
			imprimir(titols[i]);
			for (int j = 0; j < spaces; j++) {
				imprimir(" ");
			}
		}
		imprimirln("");
		for (int i = 0; i < colMaxs.length; i++) {
			for (int j = 0; j < colMaxs[i]; j++) {
				imprimir("-");
			}
		}
		imprimirln("-");
		for (int i = 0; i < contingut.length; i++) {
			imprimir(" ");
			for (int j = 0; j < contingut[0].length; j++) {
				spaces = colMaxs[j] - contingut[i][j].length();
				imprimir(contingut[i][j]);
				for (int k = 0; k < spaces; k++) {
					imprimir(" ");
				}
			}
			imprimirln("");
		}
	}
}
