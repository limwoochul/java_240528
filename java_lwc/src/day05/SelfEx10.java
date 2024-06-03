package day05;

import java.util.Scanner;

public class SelfEx10 {

	public static void main(String[] args) {
		
		//숫자 입력받아 소수 판별하기
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("소수 판별하기");
		System.out.print("판별하고 싶은 수 입력 : ");
		int num = scan.nextInt();
		int count=0;
		
		for(int i=1; i<=num; i++) {
			if(num%i == 0) {
				count++;
			}
		}
		
		if(count == 2) {
			System.out.println(num + "은 소수입니다.");
		}
		else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
		
	}

}
