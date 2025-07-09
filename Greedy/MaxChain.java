import java.util.*;

public class MaxChain{
	public static void main(String[] args) {
		int[][] arr = {{5,24},{39,60},{5,28},{27,40},{50,90}};

		Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
		int chains = 1;
		int chainend = arr[0][1];

		for(int i=1; i<arr.length; i++){
			if(arr[i][0] > chainend){
				chains++;
				chainend = arr[i][1];
			}
		}

		System.out.println(chains);
	}
}