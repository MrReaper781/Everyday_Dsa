import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		StringBuilder newStr = new StringBuilder("");
		for(int i=0; i<a.length(); i++){
		    newStr.append(a.charAt(i));
		}
		newStr.reverse();
		if(a.equals(newStr.toString())){
		    System.out.println("It is palindrome");
		}else{
		    System.out.println("It is not a palindrome");
		    
		}
	}
}
