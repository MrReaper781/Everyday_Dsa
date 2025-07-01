// You are using Java
public class Main{
    public static void printDec(int n){
        if(n == 1){
            System.out.println(n+" ");
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    
    public static void printInc(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    
    public static int printNaturalNumbers(int n){
        if(n == 1){
            return 1;
        }
        return n + printNaturalNumbers(n-1);
    }
    
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    
    public static void main(String[] args){
        int n = 5;
        // printDec(n);
        // System.out.println();
        // printInc(n);
        System.out.println(printNaturalNumbers(n));
        System.out.println(fib(n));
    }
}