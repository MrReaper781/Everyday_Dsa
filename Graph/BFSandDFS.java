// You are using Java
import java.util.*;

public class Main{
    private List<Integer>[] adjList;
    private int vertex;
    
    Main(int vertex){
        this.vertex = vertex;
        adjList = new ArrayList[vertex];
        
        for(int i=0; i<vertex; i++){
            adjList[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int i, int j){
        adjList[i].add(j);
        adjList[j].add(i);
    }
    
    public void display(){
        for(int i=0; i<vertex; i++){
            System.out.print(i+ " ");
            for(int j : adjList[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
    public void displayMatrix(){
        int[][] arr = new int[vertex][vertex];
        for(int i=0; i<vertex; i++){
            for(int j : adjList[i]){
                arr[i][j] = 1;
            }
        }
        
        for(int i =0; i<vertex; i++){
            for(int j=0; j<vertex; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
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


    
    public static void main(String[] args){
        Main obj = new Main(5);
        obj.addEdge(1, 2);
        obj.addEdge(2, 2);
        obj.addEdge(2, 4);
        obj.addEdge(0, 2);
        obj.addEdge(0, 4);
    
        obj.display();
        System.out.println();
        System.out.println();
        obj.displayMatrix();
    
        obj.bfs(0); 
        obj.dfs(0); 
    }
}