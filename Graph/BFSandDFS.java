import java.util.*;

public class BFSandDFS {
    private List<Integer>[] adjList;
    private int vertex;
    private boolean isDirected;

    @SuppressWarnings("unchecked") // Suppresses unchecked cast warning
    public BFSandDFS(int vertex, boolean isDirected) {
        this.vertex = vertex;
        this.isDirected = isDirected;
        adjList = (List<Integer>[]) new ArrayList[vertex];

        for (int i = 0; i < vertex; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Adds an edge between two vertices
    public void addEdge(int i, int j) {
        if (!adjList[i].contains(j)) {
            adjList[i].add(j);
        }
        if (!isDirected && !adjList[j].contains(i)) {
            adjList[j].add(i);
        }
    }

    // Displays the adjacency list
    public void display() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + ": ");
            for (int j : adjList[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Displays the adjacency matrix
    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        int[][] matrix = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j : adjList[i]) {
                matrix[i][j] = 1;
            }
        }

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Performs Depth-First Search
    public void dfs(int start) {
        boolean[] visited = new boolean[vertex];
        System.out.print("DFS traversal starting from node " + start + ": ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbor : adjList[current]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Performs Breadth-First Search
    public void bfs(int start) {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS traversal starting from node " + start + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        BFSandDFS graph = new BFSandDFS(5, false); // false = undirected graph

        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);

        graph.display();
        System.out.println();
        graph.displayMatrix();
        System.out.println();
        graph.bfs(0);
        graph.dfs(0);
    }
}