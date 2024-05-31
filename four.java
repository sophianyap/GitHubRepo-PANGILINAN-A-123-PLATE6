import java.util.*;

public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> numberOfDegree = new HashMap<>();

        System.out.println("Enter the edges (e.g. \"ab\") (type 'end' to finish):");

        while (true) {
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("end")){
                break;
            }

            if(input.length() != 2){
                System.out.println("Invalid edge format. lease use \"ab\" format.");
                continue;
            }

            String u = input.substring(0,1);
            String v = input.substring(1);

            // add one if degree to the vertex
            numberOfDegree.put(u, numberOfDegree.getOrDefault(u, 0) + 1);
            numberOfDegree.put(v, numberOfDegree.getOrDefault(v, 0) + 1);
        }

        System.out.println("Degrees of vertices:");     
        numberOfDegree.forEach((vertex, degree) -> {
            System.out.println("deg(" + vertex + ") = " + degree);
        });
        
        sc.close();
    }
}