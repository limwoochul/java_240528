package day05;

import java.util.Scanner;

public class SelfEx14 {

	public static void main(String[] args) {

		//숫자를 입력받아 각 자리수의 합 구하기
		
		Scanner scan = new Scanner(System.in);
		System.out.println("각 자리 수의 합 구하기");
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		int sum = 0;
		
		while(num != 0) {
			sum += num%10;
			num /= 10;
		}
		
		System.out.println("각 자리 수의 합 : " + sum);
		
	}

}
