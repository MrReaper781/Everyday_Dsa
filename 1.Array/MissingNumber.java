import java.util.Scanner;

public class MissingNumber {
    public static void missingValue(int nums[]) {
        int n = nums.length + 1;
        int total_sum = n * (n - 1) / 2;
        int cur_sum = 0;
        for (int num : nums) {
            cur_sum += num;
        }
        int missing = total_sum - cur_sum;
        System.out.println(missing);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the elements in array below \n");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        missingValue(arr);
        sc.close();
    }
}
