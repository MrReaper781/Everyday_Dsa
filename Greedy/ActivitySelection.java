import java.util.*;

public class ActivitySelection{
	public static void main(String[] args) {
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,6,7,9,9};

		int count = 1;
		int endAct = end[0];

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);

		for(int i=1; i<end.length; i++){
			if(start[i] >= endAct){
				count++;
				arr.add(i);
				endAct = end[i];
			}
		}

		System.out.println(count);
		for(int i : arr){
			System.out.print("A"+i+" ");
		}
	}
}