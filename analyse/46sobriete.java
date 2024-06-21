package iut.sae.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sobriete {

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
        if(in.isEmpty()) return "";
        StringBuilder compresse=new StringBuilder(); char lettreAct=in.charAt(0); int cpt=1;
        for(int i=1;i<in.length();i++){
            if(in.charAt(i)==lettreAct){
                cpt++;
                if(cpt==10){compresse.append(9).append(lettreAct); cpt=1;}
            }else{
                compresse.append(cpt).append(lettreAct);
                lettreAct=in.charAt(i);
                cpt=1;
            }} return compresse.append(cpt).append(lettreAct).toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if(iteration<1) throw new AlgoException();
        for(int i=0;i<iteration;i++) in=RLE(in); return in;
    }

    public static String unRLE(String in) throws AlgoException{
        if (in.isEmpty()) return "";
        StringBuilder decompresse= new StringBuilder();
        for (int i=0;i<in.length();i+=2){
            int chiffre=Character.getNumericValue(in.charAt(i));
            if((chiffre>0)||chiffre<=9){ while(chiffre-->0) decompresse.append(in.charAt(i+1)); }
        } return decompresse.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration<1) throw new AlgoException(); if (in.isEmpty()) return "";
        for (int i=0; i<iteration;i++) in=unRLE(in); return in;
    }
}


