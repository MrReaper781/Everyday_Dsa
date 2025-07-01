import java.util.Scanner;

public class SortedArrAndRotated {
    public static boolean rotate(int arr[]) {
        int countBreaks = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                countBreaks++;
            }
        }
        return countBreaks <= 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the elements in the array below:\n");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(rotate(arr));
        sc.close();
    }
}