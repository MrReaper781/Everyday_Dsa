import java.util.*;

public class InfixToPostfix {

    public static int precedence(char c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    public static String infixToPostfixConversion(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {  // Fixed method name
            if (Character.isLetterOrDigit(c)) {  // Fixed method name
                result.append(c);
            } 
            else if (c == '(') {
                stack.push(c);
            } 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {  // Fixed condition
                    result.append(stack.pop());
                }
                stack.pop();  // Pop '('
            } 
            else {  // Operator case
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println(infixToPostfixConversion(exp));
    }

    // Input : a*(b+c)/d
    // Output : abc+*d/
}