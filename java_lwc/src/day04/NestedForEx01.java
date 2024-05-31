package day04;

public class NestedForEx01 {

	public static void main(String[] args) {
		/* 구구단 2~9단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : num을 2부터 9까지 1씩 증가
		 * 규칙성 : num단 출력하는 코드
		 * 반복문 종료 후 : 없음
		 * */

		for(int dan = 2; dan < 10; dan++) {
			System.out.println("====" + dan + "단====");
			for(int times = 1; times < 10; times++) {
				System.out.println(dan + " X " + times + " = " + dan*times);
			}
			System.out.println();
		}
		
	}

}
