package day03;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = scan.nextInt();
		if(age >= 19) {
			System.out.println(age + "세는 성인입니다.");
		}
		else {
			System.out.println(age + "세는 미성년자입니다.");
		}
		
	}

}
