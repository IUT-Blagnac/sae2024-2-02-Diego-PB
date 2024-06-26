package iut.sae.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Simpliciteee {


    // *************************************************************** ********************************************
    // *************************************** Zone de test de l'algorithme ***************************************
    // ************************************************************************************************************

    public static void main(String[] args) throws AlgoException {

        System.out.println("Test de l'algorithme de compression RLE (Run-Length Encoding) pour la chaine 'SAE' :");
        String chaine = "SAE";
        System.out.println("Chaine d'entrée : " + chaine);
        String resultat = RLE(chaine);
        System.out.println("Résultat de la compression RLE : " + resultat);
        String decode = unRLE(resultat);
        System.out.println("Résultat de la décompression RLE : " + decode);
        assertEquals(chaine, decode);
        System.out.println("Test réussi !");
        System.out.println();

    }

    // *************************************************************** ********************************************
    // *************************************** Zone de test de l'algorithme ***************************************
    // ************************************************************************************************************


    public static String RLE(String in){

        String stringReturn = "";

        if (in.length() != 0) {

            Character charSelect = in.charAt(0);
            int nbChar = 1;

            for (int i = 1; i < in.length(); i++) {
                if (!charSelect.equals(in.charAt(i))) {
                    stringReturn += nbChar+""+charSelect;
                    charSelect = in.charAt(i);
                    nbChar = 1;
                } else {
                    if (nbChar == 9) {
                        stringReturn += nbChar+""+charSelect;
                        nbChar = 1;
                    } else {
                        nbChar++;
                    }
                }
            }

            if (nbChar != 0) {
                stringReturn += nbChar+""+charSelect;
            }

        }
        return stringReturn;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration < 1 ) throw new AlgoException("Impossible d'avoir une iteration < 1");
        if (iteration == 1) return RLE(in);

        return RLE(RLE(in, iteration-1));
    }

    public static String unRLE(String in) throws AlgoException{
        String result = "";

        for (int i=0; i<in.length(); i += 2) {
            for (int j=0; j< in.charAt(i) - '0'; j++) {
                result += in.charAt(i+1);
            }
        }

        return result;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration < 1 ) throw new AlgoException("Impossible d'avoir une iteration < 1");
        if (iteration == 1) return unRLE(in);

        return unRLE(unRLE(in, iteration-1));
    }
}

