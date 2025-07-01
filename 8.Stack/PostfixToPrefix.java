import java.util.*;

public class PostfixToPrefix{
	public static String postfixToPrefix(String s){
        Stack<String> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else{
                String a = stack.pop();
                String b = stack.pop();
                String exp = c+b+a;
                stack.push(exp);
            }
        }
        return stack.peek();
    }
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(postfixToPrefix(s));
	}
	
	// Input: AB-DE+F*/
	// Output: /-AB*+DEF
}