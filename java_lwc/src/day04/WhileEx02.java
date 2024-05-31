package day04;

public class WhileEx02 {

	public static void main(String[] args) {
		/* 1부터 5까지 콘솔에 출력하는 코드를 작성하세요.
		 * */
		
		int i = 1;
		while(i < 6) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("------");
		
		int j = 0;
		while(j < 10) {
			System.out.println(10 - j);
			j++;
		}
		
		System.out.println("------");
		
		int k = 10;
		while(k > 0) {
			System.out.println(k);
			k--;
		}
		
	}

}
