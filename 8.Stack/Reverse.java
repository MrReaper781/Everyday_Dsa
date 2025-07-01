import java.util.*;

public class Reverse{
    // Question 1: To push an element in bottom using recursion
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Question 2: Reverse the string using stack
    public static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    // Question 3: Reverse a stack
    public static void reverse(Stack<Integer> stack) {
        int left = 0;
        int right = stack.size() - 1;
        while (left < right) {
            int temp = stack.get(left);
            stack.set(left, stack.get(right));
            stack.set(right, temp);
            left++;
            right--;
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
    }

    // Question 4: 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Stack<Integer> stack = new Stack<>();
        // stack.push(10);
        // stack.push(20);
        // stack.push(30);

        // for (int i = 0; i < stack.size(); i++) {
        // System.out.println(stack.get(i));
        // }
        // System.out.println("Top element: " + stack.peek());
        // System.out.println();
        // stack.pop();
        // for (int i = 0; i < stack.size(); i++) {
        // System.out.println(stack.get(i));
        // }
        // System.out.println("Top element: " + stack.peek());
        // System.out.println();
        // stack.pop();
        // for (int i = 0; i < stack.size(); i++) {
        // System.out.println(stack.get(i));
        // }

        // System.out.print("Original list: ");
        // for (int i = 0; i < stack.size(); i++) {
        // System.out.print(stack.get(i) + " ");
        // }
        // System.out.println();
        // pushAtBottom(stack, 40);
        // System.out.print("After pushing an element in Bottom: ");
        // for (int i = 0; i < stack.size(); i++) {
        // System.out.print(stack.get(i) + " ");
        // }

        // String a = sc.nextLine();
        // System.out.println(reverse(a));

        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        System.out.print("Original List: ");
        for (int i = 0; i < n; i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
        System.out.print("Reverse List: ");
        reverse(stack);

        sc.close();
    }
}