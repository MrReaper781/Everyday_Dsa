import java.util.*;

public class PostfixToInfix{
	public static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();
    
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String exp = "(" + op1 + c + op2 + ")";
                stack.push(exp);
            }
        }
    
        return stack.peek();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(postfixToInfix(s));
    }


    // input : AB-DE+F*/
    // output : ((A+B)/((D+E)*F))
}