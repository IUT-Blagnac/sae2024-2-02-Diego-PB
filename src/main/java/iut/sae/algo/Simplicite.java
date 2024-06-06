package iut.sae.algo;

public class Simplicite {
    public static String RLE(String entree) {
        StringBuilder sortie = new StringBuilder();
        char caractereCourant = entree.charAt(0);
        int compteur = 1;

        for (int i = 1; i < entree.length(); i++) {
            if (entree.charAt(i) == caractereCourant) {
                if (compteur < 9) {
                    compteur++;
                } else {
                    sortie.append(9).append(caractereCourant);
                    caractereCourant = entree.charAt(i);
                    compteur = 1;
                }
            } else {
                sortie.append(compteur).append(caractereCourant);
                caractereCourant = entree.charAt(i);
                compteur = 1;
            }
        }

        sortie.append(compteur).append(caractereCourant);
        return sortie.toString();
    }
}