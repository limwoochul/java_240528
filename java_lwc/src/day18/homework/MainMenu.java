package day18.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class MainMenu implements Program {

	private final int ClientManager = 1;
	private final int ScheduleManager = 2;
	private final int EXIT = 3;
	
	private static Scanner scan = new Scanner(System.in);
	
	@Override
	public void printMenu() {
		System.out.println("-------------");
		System.out.print("메인 메뉴\n"
				+ "1. 회원 관리\n"
				+ "2. 일정 관리\n"
				+ "3. 프로그램 종료\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		
		ClientManager cm = new ClientManager();
		ScheduleManager sm = new ScheduleManager();
		
		switch(menu) {
		case ClientManager:
			cm.run();
			break;
		case ScheduleManager:
			sm.run();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");	
		}
	}


	@Override
	public void run() {
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != EXIT);
	}


}
