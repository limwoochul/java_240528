package day03;

import java.util.Scanner;

public class IfExam03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2, result = 0;
		char ch;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요(예 : 1 + 2) : ");
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
	
		if(ch == '+') {
			result = num1 + num2;
		}
		else if(ch == '-') {
			result = num1 - num2;
		}
		else if(ch == '*') {
			result = num1 * num2;
		}
		else if(ch == '/') {
			result = num1 / num2;
		}
		else {
			System.out.println("잘못된 입력입니다.");
		}
		
		System.out.println("" + num1 + " " + ch + " " + num2 + " = " + result);
		
		
	}

}
