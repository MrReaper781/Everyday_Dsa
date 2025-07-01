// You are using Java
import java.util.*;

public class Main{
    public static void binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == key){
                System.out.println("Element found at index: "+mid);
                return;
            }else if(arr[mid] > key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        for(int i=0 ; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        binarySearch(arr, key);
    }
}