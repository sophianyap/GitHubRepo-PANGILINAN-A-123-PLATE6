import java.util.*;

public class eight {

    public static boolean areIsomorphic(int[][] num1_Pangilinan, int[][] num2_Pangilinan) {
        int n1 = num1_Pangilinan.length;
        int n2 = num2_Pangilinan.length;

        if (n1 != n2) return false; // Different number of vertices

        int[] mapping = new int[n1];
        Arrays.fill(mapping, -1);

        boolean[] used = new boolean[n1];

        return isomorphicUtil(num1_Pangilinan, num2_Pangilinan, mapping, used, 0);
    }

    private static boolean isomorphicUtil(int[][] num_Pangilinan, int[][] nume_Pangilinan, int[] mapping, boolean[] used, int v) {
        int n = num_Pangilinan.length;
        if (v == n) return true;

        for (int i = 0; i < n; i++) {
            if (!used[i] && isSafe(num_Pangilinan, nume_Pangilinan, mapping, v, i)) {
                mapping[v] = i;
                used[i] = true;

                if (isomorphicUtil(num_Pangilinan,nume_Pangilinan, mapping, used, v + 1)) {
                    return true;
                }

                mapping[v] = -1;
                used[i] = false;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] num1_Pangilinan, int[][] num2_Pangilinan, int[] mapping, int v, int u) {
        for (int i = 0; i < v; i++) {
            if (num1_Pangilinan[v][i] != num2_Pangilinan[u][mapping[i]]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner_Pangilinan = new Scanner(System.in);

        System.out.print("Enter the number of vertices for both graphs: ");
        int vertices = scanner_Pangilinan.nextInt();

        System.out.println("Enter adjacency matrix for Graph 1:");
        int[][] num1_Pangilinan = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                num1_Pangilinan[i][j] = scanner_Pangilinan.nextInt();
            }
        }

        System.out.println("Enter adjacency matrix for Graph 2:");
        int[][] num2_Pangilinan = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                num1_Pangilinan[i][j] = scanner_Pangilinan.nextInt();
            }
        }

        if (areIsomorphic(num1_Pangilinan, num2_Pangilinan)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner_Pangilinan.close();
    }
}
    

