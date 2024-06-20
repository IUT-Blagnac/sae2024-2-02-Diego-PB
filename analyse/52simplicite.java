import java.util.ArrayList;


public class AlgoSimplicité1 {

    public static String RLE(String in) {

        ArrayList<Character> listCaractere = new ArrayList<>();

        for (int i = 0; i < in.length(); i++) {
            listCaractere.add(in.charAt(i));
        }

        String resultat = "";
        char currentchar = listCaractere.get(0);
        int compteurChar = 0;

        for (int i = 0; i < listCaractere.size(); i++) {
            if (listCaractere.get(i) == currentchar) {
                compteurChar++;
            } else {
                resultat += compteurChar + "" + currentchar;
                currentchar = listCaractere.get(i);
                compteurChar = 1;
            }

            if (compteurChar == 10) {
                resultat = compteurChar - 1 + "" + currentchar;
                currentchar = listCaractere.get(i);
                compteurChar = 1;
            }

        }
        resultat += compteurChar + "" + currentchar;

        return resultat;

    }

    public static String RLE(String in, int iteration) {
        ArrayList<Character> listCaractere = new ArrayList<>();
    
        for (int i = 0; i < in.length(); i++) {
            listCaractere.add(in.charAt(i));
        }

        String resultat = "";
        char currentchar = listCaractere.get(0);
        int compteurChar = 0;

           
            for (int i = 0; i < listCaractere.size(); i++) {
                for (int compteurItération = 0; compteurItération<= iteration; compteurItération++) {

                if (listCaractere.get(i) == currentchar) {
                    compteurChar++;
                } else {
                    resultat += compteurChar + "" + currentchar;
                    currentchar = listCaractere.get(i);
                    compteurChar = 1;
                }

            }
        }
        
        resultat += compteurChar + "" + currentchar;


    
        return resultat;
    }

    public static String unRLE(String in) {

        ArrayList<Character> listCaractere = new ArrayList<>();
        int i = 0;
        String resultat = "" ;
        while (i < in.length()) {
            if (in.charAt(i) >= '0' || in.charAt(i) <= '9') {
                int compteur = in.charAt(i) - '0';
                char chars = in.charAt(i + 1);

                for (int j = 0; j < compteur; j++) {
                    listCaractere.add(chars);
                }
                i += 2;
            } else {
                listCaractere.add(in.charAt(i));
                i++;
            }
            resultat ="" + listCaractere;
        }
        
        return resultat;
    }
}