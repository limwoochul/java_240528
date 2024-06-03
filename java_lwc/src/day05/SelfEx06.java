package day05;

public class SelfEx06 {

	public static void main(String[] args) {
		//230쪽 Q3
		
		int [] arr = new int[] {2,4,6,8,10};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		System.out.println("arr 배열의 합 : " + sum);
	}

}
