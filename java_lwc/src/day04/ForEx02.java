package day04;

public class ForEx02 {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하는 코드를 for문을 이용하여 작성하세요.
		 * 반복횟수 :
		 * 규칙성 :
		 * 반복문 종료 후 :
		 * */
		
		int num = 2;
		System.out.println("====" + num + "단====");
		for(int i = 1; i <= 9; i++) {
			System.out.println(num + " X " + i + " = " + num*i);
		}
		
	}

}
