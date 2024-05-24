import java.util.LinkedList;

public class Graph {
    private int v; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list for storing edges

    // Constructor to initialize the graph
    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int sr, int ds) {
        adjList[sr].add(ds); // Add edge from sr to ds
        adjList[ds].add(sr); // Add edge from ds to sr (since the graph is undirected)
    }

    // Method to print the graph
    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    // Main method to test the graph implementation
    public static void main(String[] args) {
        // Create a graph with 4 vertices
        int V = 4;
        Graph graph = new Graph(V);

        // Connect each vertex to every other vertex
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                graph.addEdge(i, j);
            }
        }

        // Print the adjacency list representation of the graph
        graph.printGraph();
    }
}
