package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import day17.contact.Contact;
import program.Program;

public class ScheduleManager implements Program {
	
	private List<Client> clientList = new ArrayList<Client>();
	private List<Schedule> list = new ArrayList<Schedule>();
	private Scanner scan = new Scanner(System.in);
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	@Override
	public void printMenu() {
		System.out.println("----------------");
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
		case EXIT:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");
		}
	}

	private void delete() {
		System.out.println("----------------");
		//날짜 받기
		System.out.print("날짜(yyyy-MM-dd) : ");
		scan.nextLine();
		String date = scan.nextLine();
		
		//이름과 일치하는 일정 받기
		List<Schedule> tmps =
				list.stream().filter(s->s.getDate().contains(date))
								.collect(Collectors.toList());
		
		//결과 없을 때
		if(tmps.size() == 0) {
			System.out.println("----------------");
			System.out.println("일치하는 일정이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println(date + " 일정 리스트");
		//받은 리스트 출력
		for(int i=0; i<tmps.size(); i++) {
			System.out.println(i+1 + ". " + tmps.get(i));
		}
		System.out.println("----------------");
		
		//번호선택
		System.out.print("삭제할 일정 선택 : ");
		int index = scan.nextInt() - 1;
		
		//번호가 0 미만 or tmps.size()보다 크거나 같으면 안내문구
		if(index < 0 || index >= tmps.size()) {
			System.out.println("----------------");
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		
		//해당 객체 가져오기
		Schedule tmp = tmps.get(index);
		
		//객체 제거
		list.remove(tmp);
		System.out.println("----------------");
		System.out.println("삭제되었습니다.");

	}

	private void update() {
		System.out.println("----------------");
		//날짜 받기
		System.out.print("날짜(yyyy-MM-dd) : ");
		scan.nextLine();
		String date = scan.nextLine();
		
		//이름과 일치하는 일정 받기
		List<Schedule> tmps =
				list.stream().filter(s->s.getDate().contains(date))
								.collect(Collectors.toList());
		
		//결과 없을 때
		if(tmps.size() == 0) {
			System.out.println("----------------");
			System.out.println("일치하는 일정이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println(date + " 일정 리스트");
		//받은 리스트 출력
		for(int i=0; i<tmps.size(); i++) {
			System.out.println(i+1 + ". " + tmps.get(i));
		}
		System.out.println("----------------");
		
		//번호선택
		System.out.print("수정할 일정 선택 : ");
		int index = scan.nextInt() - 1;
		
		//번호가 0 미만 or tmps.size()보다 크거나 같으면 안내문구
		if(index < 0 || index >= tmps.size()) {
			System.out.println("----------------");
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		
		//해당 객체 가져오기
		Schedule tmp = tmps.get(index);
		
		//날짜, 일정, 상태 입력
		System.out.println("----------------");
		System.out.print("날짜(yyyy-MM-dd hh:mm) : ");
		scan.nextLine();
		String newDate = scan.nextLine();
		System.out.print("일정 : ");
		String newSchedule = scan.nextLine();
		System.out.print("상태 : ");
		String newCondition = scan.nextLine();
		
		//list에서 tmp를 제거한 리스트 tmp2 가져오기
		List<Schedule> tmps2 =
				list.stream().filter(s->!s.equals(tmp))
								.collect(Collectors.toList());
		
		//리스트 tmp2에 있는 연락처 중 같은게 있는지 확인
		long count = tmps2.stream().filter(s->s.getDate().equals(tmp)).count();
		
		//있으면 안내문구
		if(count > 0) {
			System.out.println("----------------");
			System.out.println("이미 등록된 일정이 있습니다.");
			return;
		}
		
		//없으면 제거
		list.remove(tmp);
		
		//새로운 객체 생성
		Schedule reschedule = new Schedule(newDate, newSchedule, newCondition);
		
		//추가
		list.add(reschedule);
		
		System.out.println("----------------");
		System.out.println("수정이 완료되었습니다.");
		
	}

	private void insert() {
		System.out.println("----------------");
		//날짜, 일정, 상태 입력
		System.out.print("날짜(yyyy-MM-dd hh:mm) : ");
		scan.nextLine();
		String date = scan.nextLine();
		
		long count = list.stream().filter(c->c.getDate().equals(date)).count();
		if(count > 0) {
			System.out.println("----------------");
			System.out.println("이미 등록된 일정이 있습니다.");
			return;
		}
		System.out.print("일정 : ");
		String schedule = scan.nextLine();
		System.out.print("상태 : ");
		String condition = scan.nextLine();
		
		Schedule s = new Schedule(date, schedule, condition);
		list.add(s);
		System.out.println("----------------");
		System.out.println("일정이 추가되었습니다.");
	}

	private void search() {
		//날짜 입력
		System.out.println("----------------");
		System.out.print("날짜(yyyy-MM-dd) : ");
		scan.nextLine();
		String searchDate = scan.nextLine();
		
		long count = list.stream().filter(c->c.getDate().contains(searchDate)).count();
		if(count == 0) {
			System.out.println("일치하는 날짜가 없습니다.");
			return;
		}
		
		//date가 포함된 연락처 출력
		list.stream().filter(c->c.getDate().contains(searchDate))
					.forEach(c->System.out.println(c));
		
		System.out.println("----------------");
		System.out.print("메뉴로 가시려면 엔터를 입력하세요.");
		scan.nextLine();
	}
	

	@Override
	public void run() {
		
		String fileName = "src/day18/homework/schedule.txt";
		
		load(fileName);
		
				
		//프로그램 실행
		int menu = INSERT;
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴선택
				menu = scan.nextInt();
				//선택한 메뉴 실행
				runMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("----------------");
				System.out.println("올바른 타입을 입력하세요.");
				System.out.println("----------------");
				scan.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(menu != EXIT);
		
		
		save(fileName);
		
	}
	
	

	@Override
	public void save(String fileName) {
		//샘플 데이터를 파일에 저장
		
		try (FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
		} catch (Exception e) {
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		//파일에 있는 리스트를 가져와서 list에 저장
		
		try (FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Schedule>) ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
		
		
	}


}
