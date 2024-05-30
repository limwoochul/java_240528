package day03;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num;
		
		System.out.print("정수 입력 : ");
		num = scan.nextInt();
		
		if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수입니다.");
		}
		else {
			System.out.println(num + "는 3의 배수가 아닙니다.");
		}
		
	}

}
