package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class ContactManager implements Program{

	private Scanner scan = new Scanner(System.in);

	private String fileName = "src/day21/socket2/contact.txt";

	private List<Contact> list = new ArrayList<Contact>();

	private String ip = "192.168.30.189";

	private int port = 5001;

	@Override
	public void printMenu() {
		System.out.print(
				  "메뉴\n"
				+ "1. 연락처 추가\n"
				+ "2. 연락처 수정\n"
				+ "3. 연락처 삭제\n"
				+ "4. 연락처 확인\n"
				+ "5. 프로그램 종료\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void run() {
		int menu = 1;
		load();
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 5);
		save();
	}

	@SuppressWarnings("unchecked")
	public void load() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.flush();

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<Contact>) ois.readObject();
		} catch (Exception e) {
			load(fileName);
		}
	}

	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Contact>) ois.readObject();
		} catch (Exception e) {
		} 
	}

	public void save() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("save");
			oos.writeObject(list);
			oos.flush();

		} catch (Exception e) {
			
		} finally {
			save(fileName);
		}
	}

	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (Exception e) {
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
			System.out.println("메뉴를 잘못 입력했습니다.");
		}
	}

	private void insert() {
		scan.nextLine();
		System.out.print("번호(예:010-1234-5678) : ");
		String number = scan.nextLine(); 
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		Contact c = new Contact(number, name);
		
		if(list.contains(c)) {
			System.out.println("이미 존재하는 연락처입니다.");
			return;
		}
		list.add(c);
		System.out.println("연락처를 추가했습니다.");
	}

	private void update() {
		System.out.print("이름 검색 : ");
		String search = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().contains(search)) {
				System.out.println(i+1 + ". " + list.get(i));
			}
		}
		
		System.out.print("수정할 번호 선택 : ");
		int index = scan.nextInt() - 1;
		
		if(index < 0 || index >= list.size()) {
			System.out.println("잘못된 연락처를 선택했습니다.");
			return;
		}
		
		Contact tmp = list.get(index);
		
		System.out.print("수정할 번호 : ");
		String number = scan.next();
		System.out.print("수정할 이름 : ");
		String name = scan.next();
		
		Contact c = new Contact(number, name);
		
		for(Contact tmps : list) {
			if(tmps.equals(tmp)) continue;
			if(tmps.equals(c)) {
				System.out.println("이미 존재하는 연락처입니다.");
				return;
			}
		}
		
		list.remove(index);
		
		list.add(c);
		System.out.println("연락처를 수정했습니다.");
		
	}

	private void delete() {
		System.out.print("이름 검색 : ");
		String search = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().contains(search)) {
				System.out.println(i+1 + ". " + list.get(i));
			}
		}
		
		
		System.out.print("삭제할 번호 선택 : ");
		int index = scan.nextInt() - 1;
		
		try {
			list.remove(index);
			System.out.println("연락처를 삭제했습니다.");
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("잘못된 연락처를 선택했습니다.");
		}
		
		
	}

	private void search() {
		if(list.size() == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return;
		}
		
		System.out.print("이름 검색 : ");
		String search = scan.next();
		
		int count = 0;
		for(Contact contact : list) {
			if(contact.getName().contains(search)) {
				System.out.println(contact);
				count ++;
			}
		}
		
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}


}
