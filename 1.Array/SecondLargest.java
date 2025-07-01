import java.util.*;

public class SecondLargest {
    public static int secondlargest(int arr[]) {
        int largest = arr[0];
        int second_Largest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                second_Largest = largest;
                largest = arr[i];
            } else if (arr[i] > second_Largest && arr[i] != largest) {
                second_Largest = arr[i];
            }
        }
        return second_Largest;
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
        System.out.print(secondlargest(arr));
        sc.close();
    }
}
