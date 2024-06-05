package day07;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* 다음 메뉴를 출력하고 메뉴를 선택하면 안내문구를 출력하는 코드를 작성하세요.
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * ----------
		 * 추가했습니다.
		 * ----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * ----------
		 * 검색했습니다.
		 * ----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 0
		 * ----------
		 * 잘못된 메뉴입니다.
		 * ----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * ----------
		 * 프로그램을 종료합니다.
		 * ----------  
		 * */

		Scanner scan = new Scanner(System.in);
		int menu;

		do{
			System.out.println("메뉴\n1. 추가\n2. 검색\n3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();

			switch(menu) {
			case 1:
				System.out.println("----------\n추가했습니다\n----------");
				break;
			case 2:
				System.out.println("----------\n검색했습니다\n----------");
				break;
			case 3:
				System.out.println("----------\n프로그램을 종료합니다.\n----------");
				break;
			default :
				System.out.println("----------\n잘못된 메뉴입니다.\n----------");
				break;
			}
		}while(menu != 3);
		
	}

}
