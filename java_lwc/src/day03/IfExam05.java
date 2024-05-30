package day03;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num;
		
		System.out.print("정수 입력 : ");
		num = scan.nextInt();
		
		if(num % 2 == 0 && num % 6 != 0) {
			System.out.println("2의 배수입니다.");
		}
		else if(num % 3 == 0 && num % 6 != 0) {
			System.out.println("3의 배수입니다.");
		}
		else if(num % 6 == 0) {
			System.out.println("6의 배수입니다.");
		}
		else {
			System.out.println("2, 3, 6의 배수가 아닙니다.");
		}
	}

}
