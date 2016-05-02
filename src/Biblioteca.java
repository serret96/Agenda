import java.util.Scanner;
import java.*;
/**
 * Created by RUBEN el gayolo on 02/05/2016.
 */
public class Biblioteca {

    /* ---------- MENÚ ---------- */

    public static int menu(String[] opcions, String missatgeEscollirOpcio) {

        int opcio;

        for (int i=0; i<opcions.length; i++){
            imprimir(opcions[i]);
        }
        imprimir(missatgeEscollirOpcio);
        opcio = llegirEnter("Introdueix una opció: ");

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


}
