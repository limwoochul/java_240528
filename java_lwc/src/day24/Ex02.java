package day24;

public class Ex02 {

	public static void main(String[] args) {
		
		int num1 = 1, num2 = 2;
		
		double res = num1 / num2;
		
		/* 1 / 2 = 0.5가 출력되지 않음
		 * 원인 : 정수형끼리 나누는 결과이기 때문에 결과값도 정수형이 나온다. 따라서 실수형으로 명시적 형변환을 시킨다
		 * 해결 방법 : double res = num1 / (double) num2;
		 * */
		
		System.out.println(num1 + " / " + num2 + " = " + res);

	}

}
