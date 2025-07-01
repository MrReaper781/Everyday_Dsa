import java.util.*;

public class Main {

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example Input
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] stocks = new int[n];
        int[] span = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            stocks[i] = sc.nextInt();
        }

        stockSpan(stocks, span);

        System.out.println("Span values:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
