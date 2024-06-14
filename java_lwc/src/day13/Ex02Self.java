package day13;

import java.text.MessageFormat;
import java.util.Scanner;

public class Ex02Self {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술연산 결과를 알려주는 메소드를 정의 및 구현하고
		 * main 메소드에서 실행하는 코드를 작성하세요.
		 * 단 예외 발생 시 예외처리하는 코드를 추가하세요.
		 * */
		System.out.println("두 정수와 산술 연산자를 입력하세요.");
		System.out.print("정수1 : ");
		int num1 = scan.nextInt();
		System.out.print("연산자 : ");
		char ch = scan.next().charAt(0);
		System.out.print("정수2 : ");
		int num2 = scan.nextInt();
		
		try {
			double res = calc(num1, ch, num2);
			String format = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(format, num1, ch, num2, res));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		}
		
	/**기능 : 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 테스트
	 * @param num1 정수1
	 * @param operator 산술 연산자
	 * @param num2 정수2
	 * @return 산술 연산 결과
	 * @throws IllegalAccessException 
	 * @throws ArithmeticException 0으로 나눌 수 없다.
	 * */
	
	
	public static double calc(int num1, char ch, int num2) throws IllegalAccessException {
		
		double result;
		switch(ch) {
		case '+' :
			result = num1 + num2;
			break;
		case '-' :
			result = num1 - num2;
			break;	
		case '*' :
			result = num1 * num2;
			break;
		case '/' :
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			result = num1 / (double)num2;
			break;
		case '%' :
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			result = num1 % num2;
			break;
		default :
			throw new IllegalAccessException("잘못된 연산자 : " + ch);
		}
		
		return result;
	
	}

}
