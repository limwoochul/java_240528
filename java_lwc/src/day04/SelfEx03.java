package day04;

import java.util.Scanner;

public class SelfEx03 {

	public static void main(String[] args) {
		
		//하나의 정수값을 입력받아 소수인지 아닌지 판별
		
		Scanner scan = new Scanner(System.in);
		
		int num, i = 1, count = 0;
		
		System.out.print("정수를 입력하세요 : ");
		num = scan.nextInt();
		
		while(i <= num) {
			if(num % i == 0) {
				count++;
			}
			i++;
		}
		
		if(count == 2) {
			System.out.println(num + "은 소수입니다.");
		}
		else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
		
	}

}
