import java.util.Scanner;

public class InsertionSort {
    public static void sortInsertion(int arr[]) {
        for (int i = 1; i < arr.length; i++) { // Loop through the array starting from the second element
            int curr = arr[i]; // Store the current element
            int prev = i - 1; // Previous index
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev]; // Shift elements to the right
                prev--; // Move backward
            }

            // Insertion
            arr[prev + 1] = curr; // Insert the element at its correct position
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printArr(arr);
        System.out.println();
        sortInsertion(arr);
        printArr(arr);
        sc.close();
    }
}
