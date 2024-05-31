import java.util.*;

public class one {

    public static void main(String[] args) {
        Scanner scanner_Pangilinan = new Scanner(System.in);

        / Read the number of vertices
        System.out.println("Enter t/he number of vertices:");
        int num_Pangilinan = scanner_Pangilinan.nextInt();

        // Initialize the adjacency matrix
        int[][] adjMatrix_Pangilinan = new int[num_Pangilinan][num_Pangilinan];

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < num_Pangilinan; i++) {
            for (int j = 0; j < num_Pangilinan; j++) {
                adjMatrix_Pangilinan[i][j] = scanner_Pangilinan.nextInt();
            }
        }

        // Map to store edges and their counts
        Map<String, Integer> edgeCounMap_Pangilinan = new HashMap<>();

        // Process the adjacency matrix to list edges and count their occurrences
        for (int i = 0; i < num_Pangilinan; i++) {
            for (int j = i; j < num_Pangilinan; j++) {
                if (adjMatrix_Pangilinan[i][j] > 0) {
                    String edge_Pangilinan = "(" + i + ", " + j + ")";
                    edgeCounMap_Pangilinan.put(edge_Pangilinan, adjMatrix_Pangilinan[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCounMap_Pangilinan.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }
}