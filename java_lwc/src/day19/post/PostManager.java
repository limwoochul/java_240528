package day19.post;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import day18.homework.v1.Schedule;
import program.Program;

public class PostManager implements Program {

	private static Scanner scan = new Scanner(System.in);
	private List<Post> list = new ArrayList<Post>();
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	private String fileName = "src/day19/post/data.txt";

	@Override
	public void printMenu() {
		System.out.print("-----메뉴-----\n"
				+ "1. 게시글 등록\n"
				+ "2. 게시글 수정\n"
				+ "3. 게시글 삭제\n"
				+ "4. 게시글 조회\n"
				+ "5. 프로그램 종료\n"
				+ "메뉴 선택 : ");
	}
	
	@Override
	public void run() {
		load(fileName);
		
		Post.setCount(list.size());
		
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			printbar();
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생햇습니다.");
				e.printStackTrace();
			}
			
		}while(menu != EXIT);
		
		
		save(fileName);
	}

	private void printbar() {
		System.out.println("-------------");
		
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
			list = (List<Post>) ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		} 
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			System.out.println(list);
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
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("메뉴를 잘못 입력했습니다.");
		}
	}
	
	//게시글 삭제
	private void delete() {
		System.out.print("삭제할 게시글의 번호를 입력하세요 : ");
		int num = scan.nextInt();
		Post post = selectPost(num);
		if(post == null) return;
		
		int index = list.indexOf(post);
		confirmDelete(index);
		
	}

	private void confirmDelete(int index) {
		System.out.print("게시글을 삭제하시겠습니까?(Y/N) : ");
		char confirm = scan.next().charAt(0);
		if(confirm == 'Y' || confirm == 'y') {
			list.remove(index);
			printbar();
			System.out.println("삭제가 완료되었습니다.");
		}
		else if(confirm == 'N' || confirm == 'n') {
			return;
		}
		else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
	}

	//게시글 수정
	private void update() {
		System.out.print("수정할 게시글의 번호를 입력하세요 : ");
		int num = scan.nextInt();
		
		Post post = selectPost(num);
		if(post == null) return;
		
		
		//같으면 새 제목과 새 내용을 입력
		scan.nextLine();
		System.out.print("수정할 제목 : ");
		String title = scan.nextLine();
		System.out.print("수정할 내용 : ");
		String contents = scan.nextLine();
		//가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정
		post.update(title, contents);
		printbar();
		System.out.println(post.getNum() + "번 게시글이 수정되었습니다.");
	}


	//게시글 번호가 주어지면 게시글을 가져오는 메소드(아이디, 비번 확인)
	public Post selectPost(int num) {
		Post post = new Post(num);

		int index = list.indexOf(post);
		printbar();

		if(index < 0) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return null;
		}

		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		printbar();
		
		//가져온 객체의 아이디와 비번이 입력받은 아이디와 비번과 같은지 확인해서
		//같지 않으면 안내문구 출력 후 종료
		post = list.get(index);
		if(!post.checkWriter(id, password)) {
			System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
			return null;
		}
		return post;
	}
	
	//게시글 검색
	private void search() {
		
		if(list.size() == 0) {
			System.out.println("등록된 게시물이 없습니다.");
			return;
		}
		
		System.out.print("조회할 게시글의 제목을 입력하세요(전체검색 : 엔터) : ");
		scan.nextLine();
		String search = scan.nextLine();
		
		int count = 0;
		for(Post tmp : list) {
			if(tmp.getTitle().contains(search) || tmp.getContents().contains(search)) {
			 count++;
			}
		}
		if(count == 0) {
			printbar();
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		System.out.println("---검색 결과---");
		for(Post tmp : list) {
			if(tmp.getTitle().contains(search) || tmp.getContents().contains(search)) {
				System.out.println(tmp.toString());
			}
		}

		printbar();
		
		confirmSearch();
		
		System.out.print("메뉴로 돌아가시려면 엔터를 누르세요.");
		scan.nextLine();
		scan.nextLine();
	}

	private void confirmSearch() {
		System.out.print("게시글을 확인하시겠습니까?(Y/N) : ");
		char confirm = scan.next().charAt(0);
		if(confirm == 'Y' || confirm == 'y') {
			printbar();
			System.out.print("조회할 게시글의 번호를 입력하세요 : ");
			int idx = scan.nextInt() - 1;
			printbar();
			list.get(idx).print();
			printbar();
		}
		else if(confirm == 'N' || confirm == 'n') {
			return;
		}
		else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
	}

	//게시글 등록
	private void insert() {

		Post post = inputPost(); 
				
		list.add(post);
		
		printbar();
		System.out.println(post.getNum() + "번 게시글이 등록되었습니다.");
		
	}

	private Post inputPost() {
		scan.nextLine();
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		
		return new Post(title, contents, id, password);
	}

}
