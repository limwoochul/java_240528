package day03;

import java.util.Scanner;

public class NestedIfEx02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		double result = 0;
		char ch;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2) : ");
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
	
		if(ch == '+') {
			result = num1 + num2;
			System.out.println("" + num1 + " " + ch + " " + num2 + " = " + (int)result);
		}
		else if(ch == '-') {
			result = num1 - num2;
			System.out.println("" + num1 + " " + ch + " " + num2 + " = " + (int)result);
		}
		else if(ch == '*') {
			result = num1 * num2;
			System.out.println("" + num1 + " " + ch + " " + num2 + " = " + (int)result);
		}
		//num2가 0이면 0으로 나눌 수 없습니다 라고 출력
		else if(ch == '/') {
			if(num2 != 0) {
				result = (double)num1 / num2;
				System.out.println("" + num1 + " " + ch + " " + num2 + " = " + result);
			}
			else {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}
		//num2가 0이면 0으로 나눌 수 없습니다 라고 출력
		else if(ch == '%') {
			if(num2 != 0) {
				result = num1 % num2;
				System.out.println("" + num1 + " " + ch + " " + num2 + " = " + (int)result);
			}
			else {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}
		else {
			System.out.println("잘못된 입력입니다.");
		}
		
	}

}
