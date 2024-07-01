package day24;

public class Ex07 {

	public static void main(String[] args) {
		/* 1부터 10까지의 합을 구하려고 했다.
		 * 원인 : for문 옆에 세미콜론이 있어서 i는 10이하까지 아무런 실행문 없이 증가되고 마지막 증감식을 만나 11로 빠져나옴
		 * 따라서 sum=0 에서 i=11을 더해서 sum의값이 11로 출력
		 * 해결방법 : 세미콜론 삭제
		 * */

		int i;
		int sum=0;
		for(i=1; i<=10; i++); {
			sum += i;
		}
		System.out.println("1부터 10까지의 합 : " + sum);
		
	}

}
