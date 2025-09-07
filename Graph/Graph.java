import java.util.*;

public class Graph{
	static class Edge{
		int src, dest, wt;
		Edge(int src, int dest, int wt){
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
	}

	public static void createGraph(ArrayList<Edge>[] graph){
		for(int i=0; i<graph.length; i++){
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 5));

		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));

		graph[2].add(new Edge(2, 1, 2));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 4));

		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));

		graph[4].add(new Edge(4, 2, 2));
	}

	public static void bfsTraversal(ArrayList<Edge>[] graph){
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[graph.length];
		q.add(0);
		while(!q.isEmpty()){
			int curr = q.remove();

			if(!vis[curr]){
				System.out.print(curr + " ");
				vis[curr] = true;
				for(int i=0; i<graph[curr].size(); i++){
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
	}

	public static void dfsTraversal(ArrayList<Edge>[] graph, int curr, boolean[] vis){
		System.out.print(curr + " ");
		vis[curr] = true;

		for(int i=0; i<graph[curr].size(); i++){
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]){
				dfsTraversal(graph, e.dest, vis);
			}
		}
	}

	public static void main(String[] args) {
		int V = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];

		createGraph(graph);

		for(int i=0; i<graph[2].size(); i++){
			Edge e = graph[2].get(i);
			System.out.println(e.dest);
		}
		System.out.print("BFS Traversal: ");
		bfsTraversal(graph);
		System.out.println();
		System.out.print("DFS Traversal: ");
		dfsTraversal(graph, 0, new boolean[V]);
	}
}