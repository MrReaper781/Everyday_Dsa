import java.util.Scanner;

public class SimpleHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Precompute frequency hash
        int[] hash = new int[13]; // Assuming values are within range 0 to 12
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Read number of queries
        int q = sc.nextInt();
        while (q-- > 0) {
            int number = sc.nextInt();
            // Fetch and print the count of 'number' in array
            System.out.println(hash[number]);
        }

        sc.close();
    }
}
