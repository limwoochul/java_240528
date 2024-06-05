package day07;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/* Exam01~03 기능을 하나로 합쳐서 다음 기능을 구현하세요.
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * ----------
		 * 단어 입력 (종료:-1) : abc
		 * 단어를 추가했습니다. / 단어를 추가하지 못했습니다.
		 * 단어 입력 (종료:-1) : -1
		 * 메뉴로 돌아갑니다.
		 * ----------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * ----------
		 * 단어 입력 (종료:-1) : abc
		 * 있는 단어입니다. / 없는 단어입니다.
		 * 단어 입력 (종료:-1) : -1
		 * 메뉴로 돌아갑니다.
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
		int menu, count=0;
		String[] list = new String[10];
		String word;
		boolean result;

		do{
			System.out.println("메뉴\n1. 추가\n2. 검색\n3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();

			switch(menu) {
			
			
			case 1:
				System.out.println("----------");
				while(true) {
					System.out.print("단어 입력 (종료:-1) : ");
					word = scan.next();
					
					if(word.equals("-1")) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}
								
					
					if(count == list.length){
						System.out.println("단어를 추가하지 못했습니다.");
					}	
					else{
						list[count++] = word; 
						System.out.println("단어를 추가했습니다.");
					}	
				}
				System.out.println("----------");
				break;
				
				
			case 2:
				System.out.println("----------");
				if(list[0] == null) {
					System.out.println("저장된 단어가 없습니다.");
					System.out.println("메뉴로 돌아갑니다.");
					break;
				}
				while(true) {
					System.out.print("단어 입력 (종료:-1) : ");
					word = scan.next();
					
					if(word.equals("-1")) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}
					
					result = false;			
					for(int i = 0; i<count; i++) {
						String tmp = list[i];
						if(word.equals(tmp)) {
							result = true;
							break;
						}
					}
					
					if(result) {
						System.out.println("있는 단어입니다.");
					}
					else {
						System.out.println("없는 단어입니다.");
					}
					
				}
				System.out.println("----------");
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
