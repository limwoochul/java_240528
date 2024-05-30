package day03;

import java.util.Scanner;

public class SwitchEx03 {

	public static void main(String[] args) {
		/* 산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요(swith문으로)
		 * 예 :
		 * 두 정수와 산술 연산자를 입력하세요(예 : 1 + 2 ) : 1 + 2 [엔터]
		 * 1 + 2 = 3
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char operator;
		double result = 0;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2 ) : ");
		num1 = scan.nextInt();
		operator = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		switch(operator) {
			case '+' :
				result = num1 + num2;
				System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (int)result);
				break;
			case '-' :
				result = num1 - num2;
				System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (int)result);
				break;
			case '*' :
				result = num1 * num2;
				System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (int)result);
				break;
			case '/' :
				if(num2 != 0) {
					result = (double)num1 / num2;
					System.out.println("" + num1 + " " + operator + " " + num2 + " = " + result);
				}
				else {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				break;
			case '%' :
				if(num2 != 0) {
					result = num1 % num2;
					System.out.println("" + num1 + " " + operator + " " + num2 + " = " + (int)result);
				}
				else {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.");
		}
		
		
	}

}
