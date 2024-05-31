import java.util.*;

public class seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        sc.nextLine(); // consume the newline

        List<String> vertexList = new ArrayList<>();
        Map<String, Integer> vertexMap = new HashMap<>();
        List<String[]> edges = new ArrayList<>();

        System.out.println("Enter the edges (e.g., \"ab\"). (Type 'end' to finish):");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }

            if (input.length() != 2) {
                System.out.println("Invalid edge format. Please use the format \"ab\".");
                continue;
            }

            String u = input.substring(0, 1);
            String v = input.substring(1);

            if (!vertexMap.containsKey(u)) {
                vertexMap.put(u, vertexList.size());
                vertexList.add(u);
            }
            if (!vertexMap.containsKey(v)) {
                vertexMap.put(v, vertexList.size());
                vertexList.add(v);
            }

            edges.add(new String[]{u, v});
        }

        if (vertexList.size() != vertices) {
            System.out.println("The number of unique vertices in the edges does not match the number of vertices provided.");
            System.exit(0);
        }

        int[][] incidenceMatrix = new int[vertices][edges.size()];

        for (int i = 0; i < edges.size(); i++) {
            String[] edge = edges.get(i);
            int uIndex = vertexMap.get(edge[0]);
            int vIndex = vertexMap.get(edge[1]);
            incidenceMatrix[uIndex][i] = 1;
            if (!edge[0].equals(edge[1])) {
                incidenceMatrix[vIndex][i] = 1;
            }
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("[ ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println("]");
        }

        sc.close();
    }
}
