import java.util.*;

public class PrefixToInfix{
	public static String prefixToInfix(String s) {
	    Stack<String> stack = new Stack<>();

	    for (int i = s.length() - 1; i >= 0; i--) {
	        char c = s.charAt(i);

	        if (Character.isLetterOrDigit(c)) {
	            stack.push(c + "");
	        } else {
	            String op1 = stack.pop();
	            String op2 = stack.pop();
	            String exp = "(" + op1 + c + op2 + ")";
	            stack.push(exp);
	        }
	    }

	    return stack.peek();
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(prefixToInfix(s));
	}

	// Input : *+po-mn
	// Output: ((p+q)*(m-n))
}