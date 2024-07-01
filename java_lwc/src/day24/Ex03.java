package day24;

public class Ex03 {

	public static void main(String[] args) {
		int num = 2;
		
		/* 짝수라고 판별해야 하는데 짝수, 홀수 모두 출력이 됨
		 * 원인 : 각 if문 코드에 세미콜론이 있기 때문에 if문의 실행문이 없음 이 코드는 무시하고 홀수라는 println 코드가 실행됨
		 * 해결방법 : 세미콜론 삭제
		 * */
		
		
		if(num % 2 == 0); {
			System.out.println("짝수");
		}
		
		if(num % 2 != 0); {
			System.out.println("홀수");
		}

	}

}
