import java.util.*;

class five {

    public static int num_Pangilinan;

    public static boolean isBipartiteUtil(int G[][], int src, int colorArr[]) {
        colorArr[src] = 1;
        LinkedList<Integer> Pangilinan = new LinkedList<Integer>();
        Pangilinan.add(src);

        while (!Pangilinan.isEmpty()) {
            int u = Pangilinan.getFirst();
            Pangilinan.pop();

            if (G[u][u] == 1)
                return false;

            for (int v = 0; v < num_Pangilinan; ++v) {
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    Pangilinan.push(v);
                } else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int G[][]) {
        int colorArr[] = new int[num_Pangilinan];
        for (int i = 0; i < num_Pangilinan; ++i)
            colorArr[i] = -1;

        for (int i = 0; i < num_Pangilinan; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(G, i, colorArr) == false)
                    return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner_Pangilinan = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        num_Pangilinan = scanner_Pangilinan.nextInt();

        int G[][] = new int[num_Pangilinan][num_Pangilinan];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < num_Pangilinan; i++) {
            for (int j = 0; j < num_Pangilinan; j++) {
                G[i][j] = scanner_Pangilinan.nextInt();
            }
        }

        if (isBipartite(G))
            System.out.println("Yes, the graph is Bipartite.");
        else
            System.out.println("No, the graph is not Bipartite.");
    }
}
