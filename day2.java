import java.util.*;
public class BruteForce {
    static int[][] graph = {
            {0,1,1,0,0,0,0,1},
            {1,0,1,0,0,1,0,0},
            {1,1,0,1,1,0,0,0},
            {0,0,1,0,1,0,0,1},
            {0,0,1,1,0,0,1,0},
            {0,1,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0},
            {1,0,0,1,0,0,0,0}
    };

    static int n = 8;
    static int minColors = Integer.MAX_VALUE;
    static int[] bestSolution;

    // Nama warna (max 8 warna)
    static String[] colorNames = {
            "", "Merah", "Hijau", "Biru", "Kuning", "Ungu", "Oranye", "Coklat", "Abu-abu"
    };

    public static void main(String[] args) {
        int[] colors = new int[n];
        bruteForce(colors, 0, 1);
        System.out.println("Jumlah warna minimum: " + minColors);
        System.out.print("Pewarnaan terbaik: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Node " + (i+1) + " -> " + colorNames[bestSolution[i]] + " | ");
        }
    }
    static void bruteForce(int[] colors, int idx, int maxColorUsed) {
        if (idx == n) {
            if (isValid(colors)) {
                if (maxColorUsed < minColors) {
                    minColors = maxColorUsed;
                    bestSolution = colors.clone();
                }
            }
            return;
        }

        for (int color = 1; color <= maxColorUsed + 1; color++) {
            colors[idx] = color;
            bruteForce(colors, idx + 1, Math.max(maxColorUsed, color));
        }
    }
    static boolean isValid(int[] colors) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1 && colors[i] == colors[j]) return false;
            }
        }
        return true;
    }
}
