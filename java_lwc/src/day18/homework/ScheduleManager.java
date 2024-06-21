package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import day17.contact.Contact;
import program.Program;

public class ScheduleManager implements Program {

	private Scanner scan = new Scanner(System.in);
	private Map<String, List<Schedule>> scheduleByClient = new HashMap<String, List<Schedule>>();
	private ClientManager clientManager;
	private String clientID;
	
	public ScheduleManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int PREVIOUS = 5;
	
	@Override
	public void printMenu() {
		System.out.println("-------------");
		System.out.print("일정 메뉴\n"
				+ "1. 일정 추가\n"
				+ "2. 일정 수정\n"
				+ "3. 일정 삭제\n"
				+ "4. 일정 확인\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case PREVIOUS:
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");	
		}
	}

	private void search() {
		List<Schedule> schedules = scheduleByClient.get(clientID);
		if (schedules == null || schedules.isEmpty()) {
			System.out.println("등록된 일정이 없습니다.");
			return;
		}

		System.out.print("확인할 일정 날짜(yyyy-MM-dd): ");
		String date = scan.nextLine();

		System.out.println(date + " 일정 리스트:");
		for (Schedule schedule : schedules) {
			if (schedule.getDate().startsWith(date)) {
				System.out.println(schedule);
			}
		}
	}

	private void delete() {
		List<Schedule> schedules = scheduleByClient.get(clientID);
		if (schedules == null || schedules.isEmpty()) {
			System.out.println("등록된 일정이 없습니다.");
			return;
		}

		System.out.print("삭제할 일정 날짜(yyyy-MM-dd: ");
		String date = scan.nextLine();

		Iterator<Schedule> iterator = schedules.iterator();
		while (iterator.hasNext()) {
			Schedule schedule = iterator.next();
			if (schedule.getDate().equals(date)) {
				iterator.remove();
				System.out.println("일정이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("해당 날짜의 일정이 없습니다.");
	}

	private void update() {
		List<Schedule> schedules = scheduleByClient.get(clientID);
		if (schedules == null || schedules.isEmpty()) {
			System.out.println("등록된 일정이 없습니다.");
			return;
		}

		System.out.print("수정할 일정 날짜(yyyy-MM-dd): ");
		String date = scan.nextLine();

		for (Schedule schedule : schedules) {
			if (schedule.getDate().contains(date)) {
				System.out.print("새 일정: ");
				String newDetail = scan.nextLine();
				System.out.print("새 상태: ");
				String newStatus = scan.nextLine();
				schedule.setDetail(newDetail);
				schedule.setStatus(newStatus);
				System.out.println("일정이 수정되었습니다.");
				return;
			}
		}
		System.out.println("해당 날짜의 일정이 없습니다.");		
	}

	private void insert() {
		System.out.print("날짜(yyyy-MM-dd hh:mm): ");
		String date = scan.nextLine();
		System.out.print("일정: ");
		String detail = scan.nextLine();
		System.out.print("상태: ");
		String status = scan.nextLine();

        Schedule schedule = new Schedule(clientID, date, detail, status);
        scheduleByClient.computeIfAbsent(clientID, k -> new ArrayList<>()).add(schedule);
        System.out.println("일정이 추가되었습니다.");
	}

	@Override
	public void run() {
		System.out.print("아이디 : ");
		clientID = scan.nextLine();
		
		if(!clientManager.clientExists(clientID)) {
			System.out.println("등록되지 않은 회원입니다.");
			return;
		}
		
		manageSchdule(clientID);

	}

	private void manageSchdule(String clientID) {
		
		String fileName = "src/day18/homework/Schedule.txt";
		
		load(fileName);
		
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				scan.nextLine(); // 입력 버퍼 정리
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine(); // 입력 버퍼 정리
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (menu != PREVIOUS);
		
		save(fileName);
	}
	
	@Override
	public void save(String fileName) {
		//run()메소드에 추가한 샘플 데이터들을 이용해서 파일에 저장하는 코드를 작성하세요.
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(scheduleByClient);;
		} catch (Exception e) {
			System.out.println("저장에 실패했습니다.");
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		//파일에 있는 연락처 리스트를 가져와서 list에 저장하는 코드를 작성
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			scheduleByClient = (Map<String, List<Schedule>>) ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
	}

}
