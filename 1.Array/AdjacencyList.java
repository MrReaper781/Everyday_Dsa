import java.util.*;

public class Main {
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
            System.out.print(i + "->");
            for(int neighbour : adjList[i]){
                System.out.print(neighbour+" ");
            }
            System.out.println();
        }
    }
    
    
    public void displayMatrix(){
        int[][] arr = new int[vertex][vertex];
        for(int i=0; i< vertex; i++){
            for(int j: adjList[i]){
                arr[i][j] = 1;
            }
        }
        
        for(int i =0; i< vertex; i++){
            for(int j=0; j< vertex; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        Main obj = new Main(vertex);
        for(int i=0; i<edges; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            obj.addEdge(a-1, b-1);
        }
        
        obj.display();
        obj.displayMatrix();
    }
}