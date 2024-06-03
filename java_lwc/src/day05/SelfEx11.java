package day05;

import java.util.Scanner;

public class SelfEx11 {

	public static void main(String[] args) {

		//숫자 입력받아 피보나치 수열 출력하기
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("피보나치 수열 알아보기");
		System.out.print("알고싶은 항의 개수 입력 : ");
		int count = scan.nextInt();
		int num1 = 0, num2 = 1;
		System.out.print("피보나치 수열 : " + num2);
		
		for(int i=2; i<=count; i++) {
			int num3 = num1 + num2;
			System.out.print(" " + num3);
			num1 = num2;
			num2 = num3;
		}
		
	}

}
