import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int[][] arr = new int[vertex][vertex];
        int edges = sc.nextInt();
        for(int i=0; i<vertex; i++){
            for(int j=0; j<vertex; j++){
                arr[i][j] = 0;
            }
        }
        for(int i=0; i<edges; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }
        
        for(int i=0; i<vertex; i++){
            for(int j=0; j<vertex; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
