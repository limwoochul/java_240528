package account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class AccountManager implements Program {

	private static Scanner scan = new Scanner(System.in);
	
	private List<Account> list = new ArrayList<Account>();
	private static List<String> incomeList = new ArrayList<String>();
	private static List<String> spendList = new ArrayList<String>();
	
	@Override
	public void printMenu() {
		System.out.print(
				  "메뉴\n"
				+ "1. 내역 입력\n"
				+ "2. 내역 수정\n"
				+ "3. 내역 삭제\n"
				+ "4. 내역 조회\n"
				+ "5. 종료\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void run() {
		incomeList.add("월급");
		incomeList.add("용돈");
		incomeList.add("부수입");
		
		spendList.add("고정지출");
		spendList.add("생활비");
		spendList.add("기타");
		int menu;
		do {
			printbar();
			printMenu();
			menu = nextInt();
			printbar();
			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 5);
	}
	

	private int nextInt() {
		try {
			return scan.nextInt();			
		}catch(InputMismatchException e) {
			return Integer.MIN_VALUE;
		}
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}

	private void insert() {
		Account account = inputAccount();
		
		if(account == null) return;
		
		list.add(account);
		sort();
		System.out.println("내역이 추가되었습니다.");
	}

	private void sort() {
		Collections.sort(list);
	}

	private Account inputAccount() {
		System.out.print("날짜 : ");
		String date = scan.next();
		System.out.print("수입/지출 : ");
		String bigCategory = scan.next();
		printbar();
		if(!(bigCategory.equals("수입") || bigCategory.equals("지출"))) {
			System.out.println("잘못된 입력입니다.");
			return null;
		}
		String smallCategory;
		if(bigCategory.equals("수입")) {
			System.out.println("분류 목록");
			System.out.println(incomeList);
			System.out.print("분류 : ");
			smallCategory = scan.next();
			if(!incomeList.contains(smallCategory)) {
				System.out.println("잘못된 입력입니다.");
				return null;
			}
		}
		else {
			System.out.println("분류 목록");
			System.out.println(spendList);
			System.out.print("분류 : ");
			smallCategory = scan.next();
			if(!spendList.contains(smallCategory)) {
				System.out.println("잘못된 입력입니다.");
				return null;
			}
		}
		System.out.print("금액 : ");
		int money = nextInt();
		System.out.print("내용 : ");
		scan.nextLine();
		String detail = scan.nextLine();
		printbar();
		
		return new Account(date, bigCategory, smallCategory, detail, money);
	}

	private void update() {
		System.out.print("날짜 : ");
		String date = scan.next();
		printbar();
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getDate().contains(date)) {
				System.out.println(i+1 + ". " + list.get(i));
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색 날짜와 일치하는 내역이 없습니다.");
			return;
		}
		printbar();
		System.out.print("내역 선택 : ");
		int index = nextInt() - 1;
		printbar();
		Account newAccount = inputAccount();
		
		if(newAccount == null) {
			return;
		}
		
		list.remove(index);
		list.add(newAccount);
		sort();
		System.out.println("수정 완료!");
	}

	private void delete() {
		System.out.print("날짜 : ");
		String date = scan.next();
		printbar();
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getDate().contains(date)) {
				System.out.println(i+1 + ". " + list.get(i));
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색 날짜와 일치하는 내역이 없습니다.");
			return;
		}
		printbar();
		System.out.print("내역 선택 : ");
		int index = nextInt() - 1;
		printbar();
		
		list.remove(index);
		sort();
		System.out.println("내역이 삭제되었습니다.");
	}

	private void search() {
		System.out.println("날짜 | 수입or지출 | 분류 | 금액 | 내용");
		printbar();
		for(Account tmp : list) {
			System.out.println(tmp);
		}
	}

	private void printbar() {
		System.out.println("--------------------------------");
	}

}
