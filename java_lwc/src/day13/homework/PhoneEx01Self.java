package day13.homework;

import java.util.Scanner;

public class PhoneEx01Self {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu;
		int LIST_MAX = 10;
		PhoneNumber [] list = new PhoneNumber[LIST_MAX];
		int numberCount = 0;
		
		do {
			printMenu();
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				numberCount = insertNumber(list, numberCount);

				
				
				
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			default :
			
			
			}
			
			
		}while(menu != 5);
		System.out.println("프로그램을 종료합니다.");
		
	}

	private static PhoneNumber inputNumber() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("번호 : ");
		String number = scan.next();
		
		return new PhoneNumber(name, number);
	}

	public static int insertNumber(PhoneNumber[] list, int numberCount) {
		PhoneNumber tmp = inputNumber();
		
		if(overlapCheck(list, numberCount, tmp.getNumber())) {
			System.out.println("-----------");
			System.out.println("이미 등록된 번호입니다.");
			System.out.println("-----------");
			return numberCount;
		}

		list[numberCount++] = tmp;
				
		System.out.println("-----------");
		System.out.println("등록이 완료됐습니다.");
		System.out.println("-----------");
		
		return numberCount;
	}




	private static boolean overlapCheck(PhoneNumber[] list, int numberCount, String number) {
		
		int count = 0;
		
		for(int i=0; i<numberCount; i++) {
			if(list[i].getNumber().equals(number)) return true;
			count++;
		}
		
		
		
	}

	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	

}

class PhoneNumber{
	
	String name, number;

	public PhoneNumber(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public void print() {
		System.out.println(name + " : " + number);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	} 
	
}
