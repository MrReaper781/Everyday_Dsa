import java.util.Arrays;
import java.util.Scanner;

public class Rotation {
    // public void rotate(int[] nums, int k) {
    // int n = nums.length;
    // k = k % n;
    // int[] rotatedArr = new int[n];

    // // Rotating array
    // for (int i = 0; i < n; i++) {
    // rotatedArr[(i + k) % n] = nums[i];
    // }

    // // Printing rotated array
    // System.out.print("Rotated array: ");
    // for (int num : rotatedArr) {
    // System.out.print(num + " ");
    // }
    // System.out.println();
    // }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        System.out.println("After reversing entire array: " + Arrays.toString(nums));
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        System.out.println("After reversing first " + k + " elements: " + Arrays.toString(nums));
        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
        System.out.println("After reversing remaining elements: " + Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.print("Enter the elements in array below: \n");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the rotation value: ");
        int k = sc.nextInt();
        rotate(arr, k);
        sc.close();
    }
}
