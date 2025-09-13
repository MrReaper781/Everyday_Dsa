import java.util.*;

public class HasPath{
	static class Edge{
		int src;
		int dest;
		Edge(int src, int dest){
			this.src = src;
			this.dest = dest;
		}
	}

	static class Path{
		int src;
		int dest;
		int cnt;
		Path(int src, int dest, int cnt){
			this.src = src;
			this.dest = dest;
			this.cnt = cnt;
		}
	}

	public static void createGraph(ArrayList<Edge>[] graph){
		for(int i=0; i<graph.length; i++){
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));

		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));
	}

	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
		if(src == dest) return true;
		vis[src] = true;

		for(int i=0; i<graph[src].size(); i++){
			Edge e = graph[src].get(i);
			if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
				return true;
			}
		}

		return false;
	}

	public static int allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
	    if (src == dest) {
	        return 1; // Found one valid path
	    }

	    vis[src] = true;
	    int count = 0;

	    for (Edge e : graph[src]) {
	        if (!vis[e.dest]) {
	            count += allPath(graph, e.dest, dest, vis);
	        }
	    }

	    vis[src] = false; // Backtrack
	    return count;
	}

	public static void printList(ArrayList<Integer> arr){
		for(int i=0; i<arr.size(); i++){
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
	    int V = 7;
	    @SuppressWarnings("unchecked")
	    ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
	    createGraph(graph);

	    System.out.println("Has path from 0 to 5: " + hasPath(graph, 0, 5, new boolean[V]));
	    System.out.println("Has path from 0 to 6: " + hasPath(graph, 0, 6, new boolean[V]));

	    System.out.println("Total paths from 0 to 5: " + allPath(graph, 0, 5, new boolean[V]));
	    System.out.println("Total paths from 0 to 2: " + allPath(graph, 0, 2, new boolean[V]));
	}
}