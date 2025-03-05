import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PrimsAlgorithm {
    private class Edge {
        String vertex;
        int weight;

        public Edge(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + vertex + "," + weight + ")";
        }
    }

    private class Pair {
        String v1;
        String v2;

        public Pair(String v1, String v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return "(" + v1 + "," + v2 + ")";
        }
    }

    HashMap<String, ArrayList<Edge>> adjacencyList;

    public PrimsAlgorithm() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    public void primAlgorithm(String startVertex) {
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        ArrayList<Pair> MST = new ArrayList<>();

        for (String vertex : adjacencyList.keySet()) {
            visited.put(vertex, false);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge -> Edge.weight));
        int sum = 0;

        pq.add(new Edge(startVertex, 0));
        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();

            if (visited.get(currentEdge.vertex)) {
                continue;
            }

            visited.put(currentEdge.vertex, true);
            
            // Add edge to MST
            if (parent.containsKey(currentEdge.vertex)) {
                MST.add(new Pair(parent.get(currentEdge.vertex), currentEdge.vertex));
                sum+=currentEdge.weight ;
            }

            for (Edge edge : adjacencyList.get(currentEdge.vertex)) {
                if (!visited.get(edge.vertex)) {
                    pq.add(edge);
                    parent.put(edge.vertex,currentEdge.vertex) ;
                }
            }
        }

        System.out.println("Minimum Spanning Tree: " + MST);
        System.out.println("Total Weight: " + sum);
    }

    public static void main(String[] args) {
        PrimsAlgorithm graph = new PrimsAlgorithm();

        
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 3);
         graph.addEdge("B", "C", 1);
         graph.addEdge("B", "D", 4);
         graph.addEdge("C", "D", 2);
         

        /*graph.addEdge("A", "C", 1);
        graph.addEdge("A", "B", 2);
        graph.addEdge("C", "B", 1);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "E", 2);
        graph.addEdge("D", "E", 1); */

        graph.primAlgorithm("A");
    }

}
