import java.util.Scanner;

public class RemoveDuplicates {
    public static int removeduplicates(int arr[]) {
        int n = arr.length;
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                index++;
                arr[index] = arr[i];
            }
        }
        return index;
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
        System.out.print(removeduplicates(arr));
        sc.close();
    }
}
