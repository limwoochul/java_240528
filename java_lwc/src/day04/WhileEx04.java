package day04;

public class WhileEx04 {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 구하는 코드를 작성하세요.
		 * 
		 * 
		 * 		sum= 0
		 * i=1	sum= sum + 1
		 * i=2	sum= sum + 2
		 * i=3	sum= sum + 3
		 * ...
		 * i=10	sum= sum + 10
		 * 		sum= sum + i 
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : sum = sum + i
		 * 반복문 종료 후 : sum를 출력
		 * */
		
		int num = 1;
		int sum = 0;
		
		while(num < 11) {
			sum += num;
			num++;
		}
		
		System.out.println("1부터 10까지의 합 : " + sum);
		
	}

}
