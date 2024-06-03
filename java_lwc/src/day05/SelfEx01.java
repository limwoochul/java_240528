package day05;

public class SelfEx01 {

	public static void main(String[] args) {
		//203페이지
		
		int[] num = new int[] {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		
		System.out.println("배열의 합 : " + sum);
		
	}

}
