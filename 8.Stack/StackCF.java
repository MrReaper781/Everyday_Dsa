import java.util.*;

public class StackCF{
	public static void printStack(Stack<Integer> stack){
		for(int i : stack){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		printStack(stack);
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		printStack(stack);
		System.out.println(stack.peek());
	}
}