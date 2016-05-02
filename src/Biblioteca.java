import java.util.Scanner;
import java.*;
/**
 * Created by RUBEN el gayolo on 02/05/2016.
 */
public class Biblioteca {

    public static int menu(String[] opcions, String missatgeEscollirOpcio) {

        for (int i=0; i<opcions.length; i++){

            imprimir(opcions[i]);

        }

        imprimir(missatgeEscollirOpcio);

    }

    public static void imprimir(String text){

        System.out.print(text);

    }



}
