import java.util.Scanner;

// A diagonal exists in matrix only when it is square matrix so if it is rectangular marix the diagonal does not exist.
public class DiagonalSum {
    public static int diagonalSum(int matrix[][]) {
        int n = matrix.length;
        int sum = 0;

        /* Brute Force Approach - O(N^2) */

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // if (i == j) {
        // sum += matrix[i][j];
        // } else if (i + j == matrix.length - 1) {
        // sum += matrix[i][j];
        // }
        // }
        // }

        /* Optimal Approach - O(N) */
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i]; // diagonal sum
            sum += matrix[i][n - 1 - i]; // anti diagonal sum
        }
        if (n % 2 != 0) {
            sum -= matrix[n / 2][n / 2];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the size of squared 2D array: ");
        // int a = sc.nextInt();
        // int matrix[][] = new int[a][a];
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // matrix[i][j] = sc.nextInt();
        // }

        // }
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int c = diagonalSum(matrix);
        System.out.println("The sum of diagonal and anti-diagonal is: " + c);
        sc.close();
    }
}
