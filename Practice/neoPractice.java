// You are using Java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        double[] arr1 = new double[n];
        int[] arr2 = new int[n];
        String[] arr4 = new String[n];
        
        int[][] arr3 = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
            arr1[i] = sc.nextDouble();
            arr2[i] = sc.nextInt();
            arr4[i] = sc.next();
        }
        
        for(int i=0; i<n; i++){
            arr3[i][0] = i;
            arr3[i][1] = arr2[i];
        }
        
        mergeSort(arr3, 0, n-1);
        
        System.out.println("Sorted Student Records:");
        System.out.printf("%-10s %-6s %-5s %-10s\n", "Name", "GPA", "Age", "Major");
        for(int i=0; i<n; i++){
            System.out.printf("%-10s %-6.2f %-5d %-10s\n",arr[arr3[i][0]],arr1[arr3[i][0]],arr2[arr3[i][0]],arr4[arr3[i][0]]);
        }
    }
    
    public static void mergeSort(int[][] arr, int si, int ei){
        if(si >= ei) return;
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }
    
    public static void merge(int[][] arr, int si, int mid, int ei){
        int[][] temp = new int[ei - si + 1][2];
        int i = si;
        int j = mid+1;
        int k=0;
        
        while(i <= mid && j <= ei){
            if(arr[i][1] < arr[j][1]){
                temp[k][0] = arr[i][0];
                temp[k][1] = arr[i][1];
                i++;
            }else{
                temp[k][0] = arr[j][0];
                temp[k][1] = arr[j][1];
                j++;
            }
            k++;
        }
        
        while(i <= mid){
            temp[k][0] = arr[i][0]; 
            temp[k][1] = arr[i][1]; 
            k++; i++;
        }
        
        while(j <= ei){
            temp[k][0] = arr[j][0]; 
            temp[k][1] = arr[j][1]; 
            k++; j++;
        }
        
        for(int a=0; a<temp.length; a++){
            arr[si + a][0] = temp[a][0];
            arr[si + a][1] = temp[a][1];
        }
    }
}