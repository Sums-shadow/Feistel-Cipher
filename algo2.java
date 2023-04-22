// Chiffrement

import java.util.Scanner;

public class ChiffrementAlgo {
    
    public static int stringToBits(String s) {
        // Convertir une chaîne de 8 bits en tableau d'entiers
        int bits = new int8;
        for (int i = 0; i < 8; i++) {
            bitsi = Character.getNumericValue(s.charAt(i));
        }
        return bits;
    }
    
    public static String bitsToString(int bits) {
        // Convertir un tableau d'entiers en chaîne de 8 bits
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(bitsi);
        }
        return sb.toString();
    }
    
    public static int shiftLeft(int array, int n) {
        // Décaler un tableau vers la gauche de n positions
        int shifted = new intarray.length (http://array.length/);
        for (int i = 0; i < array.length; i++) {
            shiftedi = array(i + n) % array.length;
        }
        return shifted;
    }
    
    public static int shiftRight(int array, int n) {
        // Décaler un tableau vers la droite de n positions
        int shifted = new intarray.length (http://array.length/);
        for (int i = 0; i < array.length; i++) {
            shiftedi = array(i - n + array.length) % array.length;
        }
        return shifted;
    }
    
    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur la clé K et la permutation H
        System.out.print("Entrez la clé K (8 bits) : ");
        String kString = scanner.nextLine();
        System.out.print("Entrez la permutation H (8 chiffres) : ");
        String hString = scanner.nextLine();
        
        // Vérifier que la clé et la permutation ont la bonne longueur
        if (kString.length() != 8 || hString.length() != 8) {
            System.out.println("La clé et la permutation doivent avoir une longueur de 8 bits.");
            System.exit(0);
        }
        
        // Convertir la clé et la permutation en tableaux d'entiers
        int kBits = stringToBits(kString);
        int hPerm = stringToBits(hString);
        
        // Diviser N en deux blocs de 4 bits
        int g0Bits = new int4;
        int d0Bits = new int4;
        for (int i = 0; i < 4; i++) {
            g0Bitsi = hPermi;
            d0Bitsi = hPermi + 4;
        }
        
        // Calculer les sous-clés
        int pPerm = {2, 0, 1, 3};
        int k1Bits = new int4;
        int k2Bits = new int4;
        for (int i = 0; i < 4; i++) {
            k1Bitsi = kBitsi ^ kBitsi + 4;
            k2Bitsi = kBitsi + 4 & kBitsi;
        }
        int g1Bits = new int4;
        int d1Bits = new int4;
        for (int i = 0; i < 4; i++) {
            g1Bitsi = d0BitspPerm[i] ^ k1Bitsi;
            d1Bitsi = g0Bitsi ^ (g1Bitsi | k1Bitsi);
        }
        int g2Bits = new int4;
        int d2Bits = new int4;
        for (int i = 0; i < 4; i++) {
            g2Bitsi = d1BitspPerm[i] ^ k2Bitsi;
            d2Bitsi = g1Bitsi ^ (g2Bitsi | k2Bitsi);
        }
        
        // Concaténer les blocs G2 et D2
        int cBits = new int8;
        for (int i = 0; i < 4; i++) {
            cBitsi = g2Bitsi;
            cBitsi + 4 = d2Bitsi;
        }
        
        // Appliquer l'inverse de la permutation H
        int cPerm = new int8;
        for (int i = 0; i < 8; i++) {
            cPermhPerm[i] = cBitsi;
        }
        
        // Afficher le texte chiffré
        System.out.println("Texte chiffré : " + bitsToString(cPerm));
    }
} 