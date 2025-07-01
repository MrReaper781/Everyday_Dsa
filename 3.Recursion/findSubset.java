
import java.util.*;
public class Main{
    public static void findSubset(String str, String ans, int i){
        // base case
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        // Yes choice
        findSubset(str, (ans+str.charAt(i)), i+1);
        // No choice
        findSubset(str, ans, i+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        findSubset(str, "", 0);
    }
}