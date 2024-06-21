package day18.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class MainMenu implements Program {

	private Scanner scan = new Scanner(System.in);
	ClientManager cm = new ClientManager();
    ScheduleManager sm = new ScheduleManager(cm);
	
	private final int CLIENTMANAGER = 1;
	private final int SCHEDULEMANAGER = 2;
	private final int EXIT = 3;
	
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
		switch(menu) {
		case CLIENTMANAGER:
			cm.run();
			break;
		case SCHEDULEMANAGER:
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
			//메뉴 출력
			printMenu();
			try {
				//메뉴선택
				menu = scan.nextInt();
				//선택한 메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine(); //입력 버퍼에 남은 값들을 비워 둠
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != EXIT);
	}

}
