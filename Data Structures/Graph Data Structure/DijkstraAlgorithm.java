import java.util.*;

public class DijkstraAlgorithm {
    // Private inner class to represent an edge
    private class Edge {
        String vertex;
        int weight;

        Edge(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + vertex + ", " + weight + ")";
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

    // Adjacency list representation of the graph
    private HashMap<String, ArrayList<Edge>> adjacencyList;

    public DijkstraAlgorithm() {
        adjacencyList = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(String source, String destination, int weight, boolean isDirected) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Add edge from source to destination
        adjacencyList.get(source).add(new Edge(destination, weight));

        // If the graph is undirected, also add the reverse edge
        if (!isDirected) {
            adjacencyList.get(destination).add(new Edge(source, weight));
        }
    }

    // Dijkstra's algorithm implementation
    public HashMap<String, Integer> dijkstra(String startVertex) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        HashMap<String, Integer> distances = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
       
        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);

        priorityQueue.add(new Edge(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            String currentVertex = currentEdge.vertex;

            for (Edge edge : adjacencyList.get(currentVertex)) {
                int newDist = distances.get(currentVertex) + edge.weight;

                if (newDist < distances.get(edge.vertex)) {
                    distances.put(edge.vertex, newDist);
                    parent.put(edge.vertex, currentVertex);
                    priorityQueue.add(new Edge(edge.vertex, newDist));
                }
            }
        }
        reconstructPath("A","D", parent);
        return distances;
    }

    // Method to reconstruct and print the shortest path
    public void reconstructPath(String startVertex, String targetVertex, HashMap<String, String> parent) {
        LinkedList<String> path = new LinkedList<>();
        String current = targetVertex;

        while (current != null) {
            path.addFirst(current);
            current = parent.get(current);
        }

        if (path.getFirst().equals(startVertex)) {
            System.out.println("Shortest path from " + startVertex + " to " + targetVertex + ": " + path);
        } else {
            System.out.println("No path exists from " + startVertex + " to " + targetVertex);
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm();

        // Adding directed edges to the graph
        graph.addEdge("A", "B", 1, true);
        graph.addEdge("A", "C", 4, true);
        graph.addEdge("B", "C", 2, true);
        graph.addEdge("B", "D", 5, true);
        graph.addEdge("C", "D", 1, true);

        // Running Dijkstra's algorithm from vertex A
        HashMap<String, Integer> shortestPaths = graph.dijkstra("A");

        // Displaying shortest paths from source vertex A
        System.out.println("Shortest paths from vertex A:");
        for (String vertex : shortestPaths.keySet()) {
            System.out.println("To " + vertex + " : " + shortestPaths.get(vertex));
        }

        // Reconstructing and printing the shortest path from A to D
        //System.out.println("\nReconstructing path:");
        //graph.reconstructPath("A", "D", shortestPaths);
    }
}
