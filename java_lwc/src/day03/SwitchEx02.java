package day03;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.(switch문 이용하여)
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12, 1, 2 : 겨울
		 * 그 외 : 잘못된 월
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int month;
		
		System.out.print("월 : ");
		month = scan.nextInt();
		
		switch(month) {
			case 3, 4, 5:
				System.out.println(month + "월은 봄입니다.");
				break;
			case 6, 7, 8:
				System.out.println(month + "월은 여름입니다.");
				break;
			case 9, 10, 11:
				System.out.println(month + "월은 가을입니다.");
				break;
			case 12, 1, 2:
				System.out.println(month + "월은 겨울입니다.");
				break;
			default:
				System.out.println("잘못된 월 입니다.");
		}
		
	}

}
