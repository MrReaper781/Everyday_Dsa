import java.util.*;

public class FractionalKnapsack {
    public static double maxProfit(int[] value, int[] weight, int capacity) {
        int n = value.length;
 
        double[][] arr = new double[n][3];
        for(int i = 0; i < n; i++) {
            arr[i][0] = (double) value[i] / weight[i];
            arr[i][1] = value[i];
            arr[i][2] = weight[i];
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b[0], a[0]));

        double maxProfit = 0;
        double capacityLeft = capacity;

        for(int i = 0; i < n; i++) {
            if(capacityLeft >= arr[i][2]) {
                capacityLeft -= arr[i][2];
                maxProfit += arr[i][1];
            } else {
                maxProfit += arr[i][0] * capacityLeft;
                break;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        System.out.println("Maximum Profit: " + maxProfit(value, weight, capacity));
    }
}
