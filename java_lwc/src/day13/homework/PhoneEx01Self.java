package day13.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneEx01Self {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int menu = 0;
		int LIST_MAX = 10;
		PhoneNumber [] list = new PhoneNumber[LIST_MAX];
		int numberCount = 0;

		do {
			try {
				printMenu();
				menu = scan.nextInt();
				scan.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력하세요.");
				scan.nextLine();
				continue;
			}

			switch(menu) {
			case 1:
				numberCount = insertNumber(list, numberCount);
				break;

			case 2:
				updateNumber(list, numberCount);
				break;

			case 3:
				numberCount = deleteNumber(list, numberCount);
				break;

			case 4:
				searchNumber(list, numberCount);
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;

			default :
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 5);

	}

	public static int deleteNumber(PhoneNumber[] list, int numberCount) {

		try {
			System.out.print("검색할 이름을 작성하세요(전체 검색 : 엔터) : ");
			String name = scan.nextLine();

			printSearchNumber(list, numberCount, name);

			System.out.print("삭제할 연락처 번호 선택 : ");
			int num = scan.nextInt();

			if(!checkNumber(list, name, num-1)) {
				System.out.println("잘못된 번호를 선택했습니다");
				return numberCount;
			}

			numberCount = deleteNumberList(list, numberCount, num-1);

			System.out.println("------------------");
			System.out.println("번호를 삭제했습니다.");
			System.out.println("------------------");

		} catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요.");
			scan.nextLine();
		}
		return numberCount;
	}

	public static int deleteNumberList(PhoneNumber[] list, int numberCount, int index) {
		PhoneNumber[] tmp = new PhoneNumber[list.length];
		System.arraycopy(list, 0, tmp, 0, numberCount);

		if(numberCount != index) {
			System.arraycopy(list, index+1, list, index, numberCount-index-1);
		}
		numberCount--;
		tmp[numberCount] = null;

		return numberCount;
	}

	public static void updateNumber(PhoneNumber[] list, int numberCount) {
		try {
			System.out.print("검색할 이름을 작성하세요(전체 검색 : 엔터) : ");
			scan.nextLine();
			String name = scan.nextLine();

			printSearchNumber(list, numberCount, name);

			System.out.print("수정할 연락처 번호 선택 : ");
			int num = scan.nextInt();
			scan.nextLine();

			if(!checkNumber(list, name, num-1)) {
				System.out.println("잘못된 번호를 선택했습니다");
				return;
			}

			PhoneNumber tmp = inputNumber();

			if(overlapCheck(list, numberCount, tmp.getNumber())) {
				System.out.println("------------------");
				System.out.println("이미 등록된 번호입니다.");
				System.out.println("------------------");
				return;
			}

			list[num-1].updateNumber(tmp);
			list[num-1].print();

			System.out.println("------------------");
			System.out.println("수정이 완료됐습니다.");
			System.out.println("------------------");

		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요");
			scan.nextLine();
		}
	}

	private static boolean checkNumber(PhoneNumber[] list, String name, int index) {
		if(list.length <= index || index<0) return false;
		if(list[index] == null) return false;
		return list[index].getName().contains(name);
	}

	public static void searchNumber(PhoneNumber[] list, int numberCount) {
		System.out.print("검색할 이름을 작성하세요(전체 검색 : 엔터) : ");
		String name = scan.nextLine();

		PhoneNumber[] tmp = list;

		printSearchNumber(list, numberCount, name);

		System.out.println("------------------");
	}

	public static void printSearchNumber(PhoneNumber[] list, int numberCount, String name) {

		if(name.equals("")) {
			for(int i=0; i<numberCount; i++) {
				System.out.print(i+1 + ". ");
				list[i].print();
			}
			return;
		}


		int count = 0;

		for(int i=0; i<numberCount; i++) {
			if(list[i].getName().contains(name)) {
				System.out.print(i+1 + ". ");
				list[i].print();
				count++;
			}
		}

		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}

	}

	private static PhoneNumber inputNumber() {
		System.out.println("------------------");
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("번호 : ");
		String number = scan.next();

		return new PhoneNumber(name, number);
	}

	public static int insertNumber(PhoneNumber[] list, int numberCount) {
		PhoneNumber tmp = inputNumber();

		if(overlapCheck(list, numberCount, tmp.getNumber())) {
			System.out.println("------------------");
			System.out.println("이미 등록된 번호입니다.");
			System.out.println("------------------");
			return numberCount;
		}

		list[numberCount++] = tmp;

		System.out.println("------------------");
		System.out.println("등록이 완료됐습니다.");
		System.out.println("------------------");

		return numberCount;
	}

	private static boolean overlapCheck(PhoneNumber[] list, int numberCount, String number) {

		for(int i=0; i<numberCount; i++) {
			if(list[i].getNumber().equals(number)) return true;
		}
		return false;
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

	public void updateNumber(PhoneNumber phonenumber) {
		this.name = phonenumber.name;
		this.number = phonenumber.number;
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
