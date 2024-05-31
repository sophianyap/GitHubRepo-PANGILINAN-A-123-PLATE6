import java.util.*;

class Pangilinan_three {
    private int numVertices_Pangilinan; 
    private LinkedList<Integer> adj_Pangilinan[]; 

    Pangilinan_three(int v) {
        numVertices_Pangilinan= v;
        adj_Pangilinan = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj_Pangilinan[i] = new LinkedList<>();
    }

    void addEdge_Pangilinan(int v, int w) {
        adj_Pangilinan[v - 1].add(w - 1); 
        adj_Pangilinan[w - 1].add(v - 1); 
    }

    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj_Pangilinan[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    
    boolean isCyclic() {
        
        boolean visited[] = new boolean[numVertices_Pangilinan];
        Arrays.fill(visited, false);

        for (int u = 0; u < numVertices_Pangilinan; u++)
            if (!visited[u]) 
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner_Pangilinan = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int num_Pangilinan = scanner_Pangilinan.nextInt();

        Pangilinan_three graph_Pangilinan = new Pangilinan_three(num_Pangilinan);

        System.out.println("Enter the number of edges:");
        int numEdges_Pangilinan = scanner_Pangilinan.nextInt();

        System.out.println("Enter the edges (format: startVertex_Pangilinan endVertex_Pangilinan):");
        for (int i = 0; i < numEdges_Pangilinan; i++) {
            int startVertex_Pangilinan= scanner_Pangilinan.nextInt();
            int endVertex_Pangilinan = scanner_Pangilinan.nextInt();
            graph_Pangilinan.addEdge_Pangilinan(startVertex_Pangilinan, endVertex_Pangilinan);
        }

        if (graph_Pangilinan.isCyclic()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }

        scanner_Pangilinan.close();
    }
}
