package iut.sae.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Algo24 {

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

    public static String RLE(String in) {

        if (in == null || in.isEmpty()) {
            return "";
        }

        String newChaine = "";
        int cptChar = 1;
        char charInit = in.charAt(0);

        for (int i = 1; i < in.length(); i++) {

            if (in.charAt(i) == charInit && cptChar < 9) {
                cptChar++;

            } else {

                if (cptChar > 9) {
                    cptChar = 1;
                }else{
                    newChaine += cptChar + "" + charInit;
                    charInit = in.charAt(i);
                    cptChar = 1;
                }
            }
        }
        newChaine += cptChar + "" + charInit;
        return newChaine;
    }

    public static String RLE(String in, int iteration) throws AlgoException {

        for(int i = 0; i < iteration; i++){
            in = RLE(in);
        }

        return in;
    }

    public static String unRLE(String in) throws AlgoException {

        String newChaine = "";

        for (int i = 0; i < in.length(); i += 2) {

            int count = Character.getNumericValue(in.charAt(i));
            char character = in.charAt(i + 1);

            for (int j = 0; j < count; j++) {
                newChaine += character;
            }
        }

        return newChaine;
    }


    public static String unRLE(String in, int iteration) throws AlgoException {

        for(int i = 0; i < iteration; i++){

            in = unRLE(in);
        }
        return in;
    }
}
