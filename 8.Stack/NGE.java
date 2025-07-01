import java.util.*;

public class NGE{
	public static int[] nextGreaterElement(int[] arr){
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--){
			if(!stack.isEmpty() && stack.peek() <= arr[i]){
				stack.pop();
			}

			if(!stack.isEmpty()){
				result[i] = stack.peek();
			}else{
				result[i] = -1;
			}

			stack.push(arr[i]);
		}

		return result;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		// Brute force approach

		// int[] result = new int[n];
		// for(int i=0; i,n; i++){
		// 	for(int j=i+1; j<n; j++){
		// 		if(arr[i] < arr[j]){
		// 			result[i] = arr[j];
		// 		}
		// 	}
		// }

		int[] result = nextGreaterElement(arr);
		for(int i : result){
			System.out.print(i+" ");
		}	
	}
}