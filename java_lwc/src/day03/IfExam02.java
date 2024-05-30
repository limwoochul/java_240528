package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("월 : ");
		int month = scan.nextInt();
		
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("봄");
		}
		else if (month == 6 || month == 7 || month == 8) {
			System.out.println("여름");
		}
		else if (month == 9 || month == 10 || month == 11) {
			System.out.println("가을");
		}
		else if (month == 12 || month == 1 || month == 2) {
			System.out.println("겨울");
		}
		else {
			System.out.println("잘못된 월 입니다.");
		}
		/* 월이 3이상이고 월이 5이하이면 봄이라고 출력하고
		 * 아니면 월이 6 이상이고 월이 8 이하이면 여름이라고 출력하고
		 * 아니면 월이 9 이상이고 월이 11 이하이면 가을이라고 출력하고
		 * 아니면 월이 12이거나 월이 1이상이고 2이하이면 겨울이라고 출력하고
		 * 아니면 잘못된 월이라고 출력
		 * */
		
		System.out.print("월 : ");
		int month2 = scan.nextInt();
		
		if(month2 >= 3 && month2 <= 5) {
			System.out.println("봄");
		}
		else if(month2 >= 6 && month2 <= 8) {
			System.out.println("여름");
		}
		else if(month2 >= 9 && month2 <= 11) {
			System.out.println("가을");
		}
		else if(month2 == 12 || (month2 >= 1 && month2 <= 2)) {
			System.out.println("겨울");
		}
		else {
			System.out.println("잘못된 월 입니다.");
		}
		
		
		
	}

}
