package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import day17.contact.Contact;
import program.Program;

public class ClientManager implements Program {

	private List<Client> list = new ArrayList<Client>();
	private Scanner scan = new Scanner(System.in);

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int PREVIOUS = 4;
	private final int SEARCH = 5;


	@Override
	public void printMenu() {
		System.out.println("----------------");
		System.out.print("회원메뉴\r"
				+ "1. 회원 추가\r"
				+ "2. 회원 수정\r"
				+ "3. 회원 삭제\r"
				+ "4. 이전으로\n"
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
		case PREVIOUS:
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");
		}
	}

	private void delete() {
		System.out.println("----------------");
		System.out.print("아이디 : ");
		scan.nextLine();
		String ID = scan.nextLine();
		
		int index = -1;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getID().equals(ID)) {
				index = i;
			}
		}
		
		if(index == -1) {
			System.out.println("----------------");
			System.out.println("일치하는 아이디가 없습니다.");
			return;
		}
		
		list.remove(index);
		
		System.out.println("----------------");
		System.out.println("회원 정보를 삭제했습니다.");
	}

	private void update() {
		System.out.println("----------------");
		System.out.print("아이디 : ");
		scan.nextLine();
		String ID = scan.nextLine();
		
		int index = -1;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getID().equals(ID)) {
				index = i;
			}
		}
		
		if(index == -1) {
			System.out.println("----------------");
			System.out.println("일치하는 아이디가 없습니다.");
			return;
		}
		
	
		
		System.out.println("----------------");
		System.out.print("수정할 이름 : ");
		String newName = scan.nextLine(); 
		list.get(index).setName(newName);
		
		System.out.println("----------------");
		System.out.println("수정이 완료되었습니다.");
		
	}

	private void insert() {
		System.out.println("----------------");
		System.out.print("아이디 : ");
		scan.nextLine();
		String ID = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();

		long count = list.stream().filter(c->c.getID().equals(ID)).count();
		if(count > 0) {
			System.out.println("----------------");
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}

		Client c = new Client(ID, name);
		list.add(c);
		System.out.println("----------------");
		System.out.println("회원이 추가됐습니다.");
	}

	

	@Override
	public void run() {
		String fileName = "src/day18/homework/client.txt";

		load(fileName);

		int menu = INSERT;
		do {
			printMenu();
			menu = scan.nextInt();
			try {
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}while(menu != PREVIOUS);

		save(fileName);

	}

	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {
			System.out.println("저장에 실패했습니다.");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List <Client>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
	}


}



