import java.util.*;

public class CoinsExchange{
	public static void main(String[] args) {
		Integer[] arr = {1,2,5,10,20,50,100,500,2000};
		Arrays.sort(arr, Comparator.reverseOrder());

		ArrayList<Integer> newArr = new ArrayList<>();

		int amount = 590;
		int totalCoins = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] <= amount){
				while(arr[i] <= amount){
					totalCoins++;
					newArr.add(arr[i]);
					amount -= arr[i];
				}
			}
		}

		System.out.println("Total no. of coins: "+totalCoins);
		System.out.print("Coins - ");
		for(int i : newArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}