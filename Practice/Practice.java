import java.util.*;

public class Practice{
	// Pangram
	// public static boolean pangram(int n, String s) {
	//     if (n != s.length()) return false;
	//     String b = s.toLowerCase();
	//     Set<Character> set = new HashSet<>();

	//     for (int i = 0; i < n; i++) {
	//         char c = b.charAt(i);
	//         if (c >= 'a' && c <= 'z') {
	//             set.add(c);
	//         }
	//     }

	//     return set.size() == 26;
	// }


	//Minimize
	// public static int minimize(int a, int b){
	// 	if(a<1 || b<1 || a>10 || b>10) return 0;

	// 	int min = Integer.MAX_VALUE;
	// 	for(int i=1; i<=10; i++){
	// 		int sum = Math.abs(i - a) + Math.abs(b - i);
	// 		min = Math.min(min, sum);
	// 	}
	// 	return min;
	// }

	//Minutes before the new year
	public static int minutesLeft(int a, int b){
		int hoursToMin = a * 60;
		int totalMin = hoursToMin + b;
		return 1440 - totalMin;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Pangram
		// int n = sc.nextInt();
		// String a = sc.next();

		// if(pangram(n, a)){
		// 	System.out.println("Yes");
		// }else{
		// 	System.out.println("No");
		// }

		//Minimize
		// int n = sc.nextInt();
		// while(n-- != 0){
		// 	int a = sc.nextInt();
		// 	int b = sc.nextInt();
		// 	System.out.println(minimize(a, b));
		// }

		//Minutes left before the new year
		int n =sc.nextInt();
		while(n-- != 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(minutesLeft(a,b));
		}
	}
}