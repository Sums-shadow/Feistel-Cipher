// Dechiffrement

import java.util.Arrays;
import java.util.Scanner;

public class PermutationCipher {
    public static void main(String[] args) {
        // Demander à l'utilisateur la clé et la permutation
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez la clé (2 nombres de 4 bits séparés par un espace) : ");
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        System.out.print("Entrez la permutation (8 chiffres de 1 à 8) : ");
        int[] perm = new int[8];
        for (int i = 0; i < 8; i++) {
            perm[i] = sc.nextInt() - 1;
        }

        // Demander à l'utilisateur le texte chiffré
        System.out.print("Entrez le texte chiffré (8 bits) : ");
        int[] input = new int[8];
        for (int i = 0; i < 8; i++) {
            input[i] = sc.nextInt();
        }

        // Permute l'entrée selon la permutation donnée
        int[] permuted = new int[8];
        for (int i = 0; i < 8; i++) {
            permuted[i] = input[perm[i]];
        }

        // Divise le bloc en deux et effectue le premier round
        int[] leftHalf = Arrays.copyOfRange(permuted, 0, 4);
        int[] rightHalf = Arrays.copyOfRange(permuted, 4, 8);
        int[] g1 = permuteInverse(xor(rightHalf, k2), perm);
        int[] d1 = xor(g1, or(leftHalf, k2));

        // Effectue le deuxième round et recombine les deux moitiés
        int[] g0 = permuteInverse(xor(d1, k1), perm);
        int[] d0 = xor(g1, or(g0, k1));
        int[] output = concat(g0, d0);

        // Inverse la permutation initiale sur le texte clair sortant
        int[] plaintext = new int[8];
        for (int i = 0; i < 8; i++) {
            plaintext[perm[i]] = output[i];
        }

        // Affiche le texte clair
        System.out.print("Le texte clair est : ");
        for (int i = 0; i < 8; i++) {
            System.out.print(plaintext[i]);
        }
    }

    // Applique la permutation inverse à un bloc donné
    public static int[] permuteInverse(int[] block, int[] perm) {
        int[] result = new int[block.length];
        for (int i = 0; i < block.length; i++) {
            result[perm[i]] = block[i];
        }
        return result;
    }

    // Effectue un XOR bit à bit entre deux blocs donnés
    public static int[] xor(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] ^ b[i];
        }
        return result;
    }

    // Effectue un OR bit à bit entre deux blocs donnés
    public static int[] or(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] | b[i];
        }
    }
}