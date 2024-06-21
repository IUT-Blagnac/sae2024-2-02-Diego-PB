package iut.sae.algo;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Algo10{
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


        // Provide your algo here
        String RLE="";
        int j;
        for (int i=0;i<in.length();i+=j){
            char lettre=in.charAt(i);
            j=1;
            while(j<9 && in.length()>i+j && lettre==in.charAt(i+j)) {
                j++;
            }
            RLE+=String.valueOf(j)+lettre;
        }
        return RLE;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        for(int i=0;i<iteration;i++){
            in=RLE(in);
        }
        return in;
    }

    public static String unRLE(String in) throws AlgoException{
        if(in.length()/2!=1){
            return ("unRLE impossible : taille incorrecte");
        }
        String unRLE="";
        for(int i=0;i<in.length();i=i+2){
            switch (in.charAt(i)) {
                case 1:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 2:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 3:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 4:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 5:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 6:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 7:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 8:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                case 9:
                    for(int j=0;j<in.charAt(i);j++){
                        unRLE+=in.charAt(i+1);
                    }
                    break;
                default:
                    return("unRLE impossible: fautes d'impementation");
                break;
            }
        }
        return unRLE;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        for(int i=0;i<iteration;i++){
            in=unRLE(in);
        }
        return in;
    }

}

