import java.util.*;

public class TrappingRainwater{

    // 1. Naive approach
    // public static int trappingRainwater(int[] arr){
    //     int n = arr.length;
    //     int totalWater = 0;
    //     for(int i=0; i<n; i++){
    //         int left = 0;
    //         int right = 0;
    //         for(int j = i; j >= 0; j--){
    //             left = Math.max(left, arr[j]);
    //         }
            
    //         for(int j=i; j<n; j++){
    //             right = Math.max(right, arr[j]);
    //         }
            
    //         totalWater += Math.min(left, right) - arr[i];
    //     }
    //     return totalWater;
    // }
    
    // 2. Better Approach (Prefix array approach)

    // public static int trappingRainwater(int[] arr){
    //     int n = arr.length;
    //     int[] leftMaxArr = new int[n];
    //     int[] rightMaxArr = new int[n];

    //     leftMaxArr[0] = arr[0];
    //     for (int i = 1; i < n; i++) {
    //         leftMaxArr[i] = Math.max(leftMaxArr[i - 1], arr[i]);
    //     }
        
    //     rightMaxArr[n - 1] = arr[n - 1];
    //     for (int i = n - 2; i >= 0; i--) {
    //         rightMaxArr[i] = Math.max(rightMaxArr[i + 1], arr[i]);
    //     }
        
    //     int totalWater = 0;
    //     for(int i=0; i<n; i++){
    //         totalWater += Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
    //     }
        
    //     return totalWater;
    // }

    // 3. Optimal approach (two pointers approach)
    public static int trappingRainwater(int[] arr){
        int totalWater = 0;
        int left = 0;
        int right = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            
            if(leftMax < rightMax){
                totalWater += (leftMax - arr[left]);
                left++;
            }else{
                totalWater += (rightMax - arr[right]);
                right--;
            }
        }
        
        return totalWater;
    }



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
		    arr[i] = sc.nextInt();
		}
		System.out.println(trappingRainwater(arr));
 	}
}
