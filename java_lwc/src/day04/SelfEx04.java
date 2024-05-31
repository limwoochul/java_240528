package day04;

import java.util.Scanner;

public class SelfEx04 {

	public static void main(String[] args) {
		// 정수 값을 두개 입력받아 두 수의 최대공약수 구하기
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2, i = 1, gcd = 0;
		
		System.out.print("두 개의 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		while(i <= num1) {
			if(num1%i==0 && num2%i==0) {
				gcd = i;
			}
			i++;
		}
		
		System.out.println(num1 + "과 " + num2 + "의 최대공약수는 " + gcd + "입니다.");

	}

}
