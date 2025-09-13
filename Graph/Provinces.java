import java.util.*;

public class Provinces{
	public static int province(int[][] graph){
		int n = graph.length;
		boolean[] visited = new boolean[n];
		int count = 0;

		for(int i=0; i<n; i++){
			if(!visited[i]){
				count++;
				dfs(graph, visited, i);
			}
		}

		return count;
	}

	private static void dfs(int[][] graph, boolean[] visited, int city){
		visited[city] = true;
		for(int i=0; i<graph.length; i++){
			if(graph[city][i] == 1 && !visited[i]){
				dfs(graph, visited, i);
			}
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{1,1,0}, {1,1,0}, {0,0,1}};
		System.out.println(province(arr));
	}
}