package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import day17.contact.Contact;
import program.Program;

public class ClientManager implements Program{

	private Map<String, Client> client = new HashMap<String, Client>();
	private Scanner scan = new Scanner(System.in);
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int PREVIOUS = 4;
	
	
	@Override
	public void printMenu() {
		System.out.println("-------------");
		System.out.print("회원 메뉴\n"
				+ "1. 회원 추가\n"
				+ "2. 회원 수정\n"
				+ "3. 회원 삭제\n"
				+ "4. 이전으로\n"
				+ "메뉴 선택 : ");
		System.out.println(client);
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
		System.out.print("아이디 : ");
		scan.nextLine();
		String id = scan.nextLine();

		if (client.remove(id) != null) {
			System.out.println("회원 정보를 삭제했습니다.");
		} else {
			System.out.println("해당 아이디의 회원이 없습니다.");
		}
	}

	private void update() {
		System.out.print("아이디 : ");
		scan.nextLine();
		String id = scan.nextLine();
		if (client.containsKey(id)) {
			System.out.print("수정할 이름: ");
			String name = scan.nextLine();
			Client C = new Client(id, name);
			client.put(id, C);
			System.out.println("회원 정보가 수정되었습니다.");
		} else {
			System.out.println("해당 아이디의 회원이 없습니다.");
		}
	}

	private void insert() {
		System.out.print("아이디 : ");
		scan.nextLine();
		String id = scan.nextLine();
		
		if(client.containsKey(id)) {
			System.out.println("이미 등록된 아이디입니다.");
			return;
		}
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		Client c = new Client(id, name);
		client.put(id, c);
		System.out.println("회원이 추가됐습니다.");
	}

	@Override
	public void run() {
		String fileName = "src/day18/homework/client.txt";
		
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
			}catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요.");
				scan.nextLine(); //입력 버퍼에 남은 값들을 비워 둠
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(menu != PREVIOUS);
		
		save(fileName);
	}
	
    public boolean clientExists(String clientId) {
        return client.containsKey(clientId);
    }

	@Override
	public void save(String fileName) {
		//run()메소드에 추가한 샘플 데이터들을 이용해서 파일에 저장하는 코드를 작성하세요.
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(client);
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
			client = (Map<String, Client>) ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다." + e.getMessage());
		}
	}	
	
}
