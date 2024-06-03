package day05;

public class LCMEx01 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * A의 배수 B : B를 A로 나누었을 때 나머지가 0인 B를 A의 배수라고 표현.
		 * 6의 배수 : 6, 12, 18, 24, 30, ...
		 * 8의 배수 : 8, 16, 24, 32, 40, ...
		 * 공배수 : 두 수의 배수 중 공통으로 있는 수
		 * 6과 8의 공배수 : 24, 48, 72, ...
		 * 최소공배수 : 두 수의 공배수 중 가장 작은 수
		 * 6과 8의 최소공배수 : 24
		 * 
		 * 반복횟수 : i는 1부터 무한대까지 1씩 증가
		 * 규칙성 : i가 num1의 배수이고 i가 num2의 배수이면 i를 출력한 후 반복문 종료
		 * 		=> i를 num1로 나누었을 때 나머지가 0 과 같고 i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 		   i를 출력한 후 반복문을 종료
		 * 반복문 종료 후 : 없음
		 * */
		
		int num1 = 6, num2 = 8;
		
		for(int i = 1; ; i++){
			if(i%num1 == 0 && i%num2 == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최소공배수 : " + i);
				break;
			}
		}

		//num3이 num4보다 작으면 num3과 num4를 바꾸는 코드(두 수를 바꾸는 코드)
		//num3이 111이고 num4가 30000이면 num4을 30000으로, num3을 111로 수정하는 코드
		
		
		int num3 = 6, num4 = 8;
		int tmp; 
		if(num3 < num4) {
			tmp = num3;
			num3 = num4;
			num4 = tmp;
		}
		
		/* 반복횟수 : i는 num3부터 무한대까지 num4씩 증가 => i는 num3의 배수들만 사용
		 * 규칙성 : i 는 num3의 배수이면 i를 출력하고 반복문 종료
		 * 반복문 종료 후 : 없음
		 * */
		
		for(int i = num3; ; i += num3) {
			if(i % num4 ==0) {
				System.out.println(num3 + "과 " + num4 + "의 최소공배수 : " + i);
				break;
			}
		}
		
		
		
		
	}

}
