import java.util.Scanner;

public class SortedMatrixSearch {
    public static boolean matrixSearch(int matrix[][], int key) {
        // Brute Force Approach

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // if (matrix[i][j] == key) {
        // System.out.print("Element found at row: " + (i + 1) + ", column: " + (j +
        // 1));
        // return true;
        // }
        // }
        // }

        // Better Approach(Binary Search)

        // int rows = matrix.length, cols = matrix[0].length;

        // for (int i = 0; i < rows; i++) {
        // int left = 0, right = cols - 1;

        // while (left <= right) {
        // int mid = left + (right - left) / 2;

        // if (matrix[i][mid] == key) {
        // System.out.println("Element found at row: " + (i + 1) + ", column: " + (mid +
        // 1));
        // return true;
        // } else if (matrix[i][mid] < key) {
        // left = mid + 1; // Move right
        // } else {
        // right = mid - 1; // Move left
        // }
        // }
        // }

        // Optimal Approach (Staircase Approach)
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Element found at row: " + (row + 1) + ", column: " + (col + 1));
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else if (key > matrix[row][col]) {
                row++;
            }
        }
        System.out.println("Element not found.");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        int key = sc.nextInt();
        System.out.print(matrixSearch(matrix, key));
        sc.close();
    }
}
