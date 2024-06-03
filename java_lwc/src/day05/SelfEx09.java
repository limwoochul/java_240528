package day05;

import java.util.Scanner;

public class SelfEx09 {

	public static void main(String[] args) {

		//숫자를 입력받아 팩토리얼 계산하기
		
		Scanner scan = new Scanner(System.in);
		System.out.println("팩토리얼 계산하기");
		System.out.print("구하고 싶은 수 : ");
		int num = scan.nextInt();
		int total=1;
		
		for(int i=1; i<=num; i++) {
			total *= i;
		}
		
		System.out.println(num + "! : " + total);
		
		
	}

}
