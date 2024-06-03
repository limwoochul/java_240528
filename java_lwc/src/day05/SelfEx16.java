package day05;

import java.util.Scanner;

public class SelfEx16 {

	public static void main(String[] args) {
		
		// 두 정수를 입력받고 두 정수의 최소공배수 찾기
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("정수2 입력 : ");
		int num2 = scan.nextInt();
		
		if(num1 < num2) {
			int num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		
		int result;
		for(int i=num1; ; i+=num1) {
			if(i%num2 ==0) {
				result = i;
				break;
			}
		}
		
		System.out.println(num1 + "과 " + num2 + "의 최소공배수 : " + result);

	}

}
