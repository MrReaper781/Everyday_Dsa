public class Recursion{
    
    // 1. Print number in decreasing order -> 5 4 3 2 1
    public static void printDec(int n){
        if(n == 0){
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    
    // 2. Print number in increasing order -> 1 2 3 4 5
    public static void printInc(int n){
        if(n == 0){
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    
    // 3. Print factorial of n -> if n = 5 then 5! = 120
    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
    
    // 4. Print sum of natural numbers -> if n = 5 then first n natural numbers = 15
    public static int sumOfN(int n){
        if(n == 0){
            return 0;
        }
        return n + sumOfN(n-1);
    }
    
    // 5. Print fibonacci number -> if n = 5 then the nth fibonacci number is 3
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    
    // 6. Check if array is sorted or not
    public static boolean checkSorted(int[] arr, int i){
        if(i == arr.length - 1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return checkSorted(arr, i+1);
    }
    
    // 7. Check first occurence of the number
    public static int firstOccurence(int[] arr, int key, int idx){
        if(idx == arr.length - 1){
            return -1;
        }
        if(arr[idx] == key){
            return idx;
        }
        return firstOccurence(arr, key, idx+1);
    }
    
    // 8. Print x to the power of n without using math method  - not optimized one
    public static int power(int num, int pow){
        if(pow == 0){
            return 1;
        }
        return num * power(num, pow-1);
    }
    
    // 9. Print x to the power of n without using math method - optimized one
    public static int optimized(int x, int i){
        if(i == 0){
            return 1;
        }
        int halfPower = optimized(x, i/2);
        int halfPowerSq = halfPower * halfPower;
        
        if(i % 2 != 0){
            halfPowerSq = x * halfPowerSq;
        }
        
        return halfPowerSq;
    }
    
    // 10. 
    
	public static void main(String[] args) {
		int n = 5;
		printDec(n);
		System.out.println();
		printInc(n);
		System.out.println();
		System.out.println(factorial(n));
		System.out.println(sumOfN(n));
		System.out.println(fib(n));
		int[] arr = {1,2,3,4,5,6};
		System.out.println(checkSorted(arr, 0));
		int key = 4;
		System.out.println(firstOccurence(arr, key, 0));
		System.out.println(power(n, 3));
		System.out.println(optimized(n, 3));
	}
}
