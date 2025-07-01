import java.util.*;

public class MyListExample {
    // Example 1 - Find the maximum number
    public static int maxNumber(ArrayList<Integer> num) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < num.size() - 1; i++) {
            if (num.get(i) > max) {
                max = num.get(i);
            }
        }
        return max;
    }

    // Example 2 - Swap the two numbers
    public static void swapIndex(ArrayList<Integer> list, int si, int ei) {
        int temp = list.get(si);
        list.set(si, list.get(ei));
        list.set(ei, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);

        // // Forward traversal
        // System.out.println("Forward:");
        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(list.get(i) + " ");
        // }

        // // Reverse traversal
        // System.out.println("\nReverse:");
        // for (int i = list.size() - 1; i >= 0; i--) {
        // System.out.print(list.get(i) + " ");
        // }
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(4);
        list.add(1);
        int c = maxNumber(list);
        System.out.println(c);

        System.out.println(list);
        swapIndex(list, 1, 3);
        System.out.println(list);
    }
}
