// You are using Java
import java.util.*;

public class InfixToPrefix{
    public static String reverse(String s){
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '('){
                result.append(')');
            }
            else if(c == ')'){
                result.append('(');  
            }else{
                result.append(c);
            }
        }
        result.reverse();
        return result.toString();
    }
    
    public static int precedence(char c){
        if(c == '^') return 3;
        else if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return -1;
    }
    
    public static String infixToPostFix(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    
    public static String infixToPrefix(String s){
	    String reversed = reverse(s);      
	    String postfix = infixToPostFix(reversed); 
	    String prefix = new StringBuilder(postfix).reverse().toString(); 
	    return prefix;
	}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // System.out.println(reverse(s));
        System.out.println(infixToPrefix(s));
    }


    // Input : (a+b)*c-d+f
    // Output: -*+abc+df
}