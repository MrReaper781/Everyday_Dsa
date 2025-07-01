import java.util.*;

public class MinSubArraySum{

    // 1. Brute Force Approach
    // public static int minSubArraySum(int[] arr) {
    //     int n = arr.length;
    //     int sum = 0;
    //     for (int i = 0; i < n; i++) {
    //         int currentMin = Integer.MAX_VALUE;
    //         for (int j = i; j < n; j++) {
    //             currentMin = Math.min(currentMin, arr[j]);
    //             sum += currentMin;
    //         }
    //     }
    //     return sum;
    // }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
		    arr[i] = sc.nextInt();
		}
        System.out.println(minSubArraySum(arr));
	}
}
