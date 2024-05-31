import java.util.*;
//by Anya Sophia Pangilinan
public class two {

    public static void main(String[] args) {
        Scanner scanner_Pangilinan = new Scanner(System.in);

        // Read the number of vertices
        System.out.println("Enter the number of vertices:");
        int numVertices_Pangilinan = scanner_Pangilinan.nextInt();

        // Initialize the adjacency matrix
        int[][] adjMatrix_Pangilinan = new int[numVertices_Pangilinan]
        [numVertices_Pangilinan];

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < numVertices_Pangilinan; i++) {
            for (int j = 0; j < numVertices_Pangilinan; j++) {
                adjMatrix_Pangilinan[i][j] = scanner_Pangilinan.nextInt();
            }
        }

        // Map to store edges and their counts
        Map<String, Integer> edgeCountMap_Pangilinan  = new HashMap<>();

        // Process the adjacency matrix to list edges and count their occurrences
        for (int i = 0; i < numVertices_Pangilinan; i++) {
            for (int j = i + 1; j < numVertices_Pangilinan; j++) {  // start j from i + 1 to avoid counting self-loops and duplicate edges
                if (adjMatrix_Pangilinan[i][j] > 0) {
                    String edge = "(" + i + ", " + j + ")";
                    edgeCountMap_Pangilinan.put(edge, edgeCountMap_Pangilinan.getOrDefault
                    (edge, 0) + adjMatrix_Pangilinan[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap_Pangilinan.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }

        scanner_Pangilinan.close();
    }
}
