import java.util.*;

public class PrefixToPostfix{
	public static String prefixToPostfix(String s){
        Stack<String> stack = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else{
                String a = stack.pop();
                String b = stack.pop();
                String exp = a+b+c;
                stack.push(exp);
            }
        }
        return stack.peek();
    }
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(prefixToPostfix(s));
	}
	
	// Input: /-AB*+DEF
	// Output: AB-DE+F*/
}