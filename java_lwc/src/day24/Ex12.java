package day24;

public class Ex12 {

	public static void main(String[] args) {
		/* 1+2의 결과를 출력하기 위해 다음과 같이 작성했다.
		 * 원인 : 리턴 타입이 없는데 클래식 메소드를 int로 호출했기 때문에
		 * 해결방법 : int형 변수로 지정하지 않거나 메소드 리턴타입을 int로 지정
		 * */
		//int res = sum(1, 2);
		sum(1,2);
	}
	public static void sum(int num1, int num2) {
		System.out.println(num1 + num2);
	}
}
