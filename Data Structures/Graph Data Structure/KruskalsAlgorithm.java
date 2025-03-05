import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {
    private class Edge implements Comparable<Edge> {
        String source;
        String destination;
        int weight;

        public Edge(String source, String destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            return "(" + source + "," + destination + "," + weight + ")";
        }
    }

    private ArrayList<Edge> edges;
    private HashMap<String, String> parent;
    private HashMap<String, Integer> rank;

    public KruskalsAlgorithm() {
        edges = new ArrayList<>();
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight) {
        edges.add(new Edge(source, destination, weight));
        parent.putIfAbsent(source, source);
        parent.putIfAbsent(destination, destination);
        rank.putIfAbsent(source, 0);
        rank.putIfAbsent(destination, 0);
    }

    private String find(String vertex) {
        if (!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent.get(vertex))); // Path compression
        }
        return parent.get(vertex);
    }

    private void union(String vertex1, String vertex2) {
        String root1 = find(vertex1);
        String root2 = find(vertex2);

        if (!root1.equals(root2)) {
            // Union by rank
            if (rank.get(root1) < rank.get(root2)) {
                parent.put(root1, root2); // Attach smaller tree under larger tree
            } else if (rank.get(root1) > rank.get(root2)) {
                parent.put(root2, root1);
            } else {
                parent.put(root2, root1); // Attach and increase rank
                rank.put(root1, rank.get(root1) + 1);
            }
        }
    }

    public void kruskalAlgorithm() {
        // Sort edges based on weight
        Collections.sort(edges);

        ArrayList<Edge> MST = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (find(edge.source).equals(find(edge.destination))) {
                continue; // Skip if it forms a cycle
            }
            union(edge.source, edge.destination);
            MST.add(edge);
            totalWeight += edge.weight;
        }

        System.out.println("Minimum Spanning Tree: " + MST);
        System.out.println("Total Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        KruskalsAlgorithm graph = new KruskalsAlgorithm();

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 2);

        graph.kruskalAlgorithm();
    }
}