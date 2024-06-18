package Day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02Self {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 번호 추가
		 * 2. 번호 삭제
		 * 3. 번호 조회 (sysout(list))로 대체
		 * 4. 종료
		 * */
		
		int menu;
		ArrayList<String> list = new ArrayList<String>();
		
		do {
			
			printMenu();
			menu = scan.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.println("---------------");
				System.out.print("전화번호 입력 : ");
				String number = scan.next();
				if(list.contains(number)) {
					System.out.println("이미 등록된 번호입니다.");
					System.out.println("---------------");
				}
				else {					
					list.add(number);
					System.out.println("번호 등록이 완료되었습니다.");
					System.out.println("---------------");
				}
				break;
			
			case 2:
				System.out.println("---------------");
				System.out.print("삭제할 전화번호 입력 : ");
				if(list.remove(scan.next())) {
					System.out.println("삭제가 완료되었습니다.");
					System.out.println("---------------");
				}
				else {
					System.out.println("입력한 번호가 존재하지 않습니다.");
					System.out.println("---------------");
				}
				break;
				
			case 3:
				System.out.println("---------------");
				System.out.println(list);
				System.out.println("---------------");
				break;
				
			case 4:
				System.out.println("---------------");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("---------------");
				break;
				
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
			
			}
			
			
			
		}while(menu != 4);

	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 번호 추가");
		System.out.println("2. 번호 삭제");
		System.out.println("3. 번호 조회");
		System.out.println("4. 종료");
		System.out.print("메뉴 입력 : ");	
	}

}
