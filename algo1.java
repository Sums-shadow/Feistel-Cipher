// Generation des clés


import java.util.Scanner;

public class GenerationCleAlgo {
    
    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur la clé K et la permutation H
        System.out.print("Entrez la clé K (8 bits) : ");
        String k = scanner.nextLine();
        System.out.print("Entrez la permutation H (8 chiffres) : ");
        String h = scanner.nextLine();
        
        // Vérifier que la clé et la permutation ont la bonne longueur
        if (k.length() != 8 || h.length() != 8) {
            System.err.println("La clé et la permutation doivent avoir une longueur de 8 bits.");
            return;
        }
        
        // Convertir la clé et la permutation en tableaux d'entiers
        int kBits = stringToBits(k);
        int hPerm = stringToPerm(h);
        
        // Diviser K en deux blocs de 4 bits
        int k1Bits = new int4;
        int k2Bits = new int4;
        for (int i = 0; i < 4; i++) {
            k1Bitsi = kBitsi ^ kBitsi+4;
            k2Bitsi = kBitsi+4 & kBitsi;
        }
        
        // Demander à l'utilisateur l'ordre de décalage pour k1 et k2
        System.out.print("Entrez l'ordre de décalage pour k1 : ");
        int shift1 = scanner.nextInt();
        System.out.print("Entrez l'ordre de décalage pour k2 : ");
        int shift2 = scanner.nextInt();
        
        // Appliquer les décalages à k1 et k2
        int k1Shifted = shiftLeft(k1Bits, shift1);
        int k2Shifted = shiftRight(k2Bits, shift2);
        
        // Afficher les sous-clés générées
        System.out.println("Sous-clé 1 : " + bitsToString(k1Shifted));
        System.out.println("Sous-clé 2 : " + bitsToString(k2Shifted));
    }
    
    // Convertir une chaîne de 8 chiffres en tableau d'entiers
    private static int stringToPerm(String s) {
        int perm = new int8;
        for (int i = 0; i < 8; i++) {
            permi = Character.getNumericValue(s.charAt(i));
        }
        return perm;
    }
    
    // Convertir une chaîne de 8 bits en tableau d'entiers
    private static int stringToBits(String s) {
        int bits = new int8;
        for (int i = 0; i < 8; i++) {
            bitsi = Character.getNumericValue(s.charAt(i));
        }
        return bits;
    }
    
    // Convertir un tableau d'entiers en chaîne de 8 bits
    private static String bitsToString(int bits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(bitsi);
        }
        return sb.toString();
    }
    
    // Décaler un tableau d'entiers vers la gauche de n positions
    private static int shiftLeft(int array, int n) {
        int shifted = new intarray.length (http://array.length/);
        for (int i = 0; i < array.length; i++) {
            shiftedi = array(i + n) % array.length;
        }
        return shifted;
    }
    
    // Décaler un tableau d'entiers vers la droite de n positions
    private static int shiftRight(int array, int n) {
        int shifted = new intarray.length (http://array.length/);
        for (int i = 0; i < array.length; i++) {
            shiftedi = array(i - n + array.length) % array.length;
        }
        return shifted;
    }
    
}