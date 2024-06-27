package studentself;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;


public class StudentManager implements Program {

	//학생 성적 관리를 위한 리스트
	private List<Student> list = new ArrayList<Student>();
	//과목 관리를 위한 리스트
	private List<Subject> subjectList = new ArrayList<Subject>();
	private Scanner scan = new Scanner(System.in);
	
	
	@Override
	public void printMenu() {
		System.out.print(
				  "메뉴\n"
				+ "1. 학생 관리\n"
				+ "2. 과목 관리\n"
				+ "3. 종료\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void run() {
		int menu;
		do {
			printMenu();
			menu = nextInt();
			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 3);
	}
	/**
	 * 콘솔에서 정수를 입력받아 반환하는 메소드로 잘못입력하면(문자열) 정수의 가장 작은 수를 반환
	 * @return 입력한 정수 또는 정수의 가작 작은 수
	 */
	public int nextInt() {
		try {
			return scan.nextInt();
		} catch(InputMismatchException e) {
			scan.nextLine();//잘못 입력한 값을 입력 버퍼에서 비워줌
			return Integer.MIN_VALUE;//int의 가장 작은 수를 리턴
		}
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			exit();
			break;
		default:
			
		}
	}

	private void student() {
		int menu;
		do {
			printStudentMenu();
			menu = nextInt();
			runStudentMenu(menu);	
		}while(menu != 5);
	}

	private void printStudentMenu() {
		System.out.print(
				  "학생 관리 메뉴\n"
				+ "1. 학생 추가\n"
				+ "2. 학생 수정\n"
				+ "3. 학생 삭제\n"
				+ "4. 학생 조회\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}

	private void runStudentMenu(int menu) {
		switch(menu) {
		case 1:
			studentInsert();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentDelete();
			break;
		case 4:
			studentSearch();
			break;
		case 5:
			prev();
			break;
		default:
			
		}
	}

	private void studentInsert() {
		Student std = inputStudentExpand();
		
		if(list.contains(std)) {
			System.out.println("이미 등록된 학년, 반, 번호입니다.");
			return;
		}			

		list.add(std);
		System.out.println("학생이 추가되었습니다.");
	}
	/**학년, 반, 번호를 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * @return 학년, 반, 번호가 있는 만들어진 학생 객체
	 * */
	public Student inputStudent() {
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("반 : ");
		int classNum = nextInt();
		System.out.print("번호 : ");
		int num = nextInt();

		return new Student(grade, classNum, num, "");
	}
	/**학년, 반, 번호를 입력받아 학생 객체를 만들어서 만환하는 메소드
	 * @return 학년, 반, 번호, 이름이 있는 만들어진 학생 객체
	 * */
	public Student inputStudentExpand() {
		Student std = inputStudent();
		
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		std.setName(name);
		return std;
	}

	private void studentUpdate() {
		int menu;
		do {
			printStudentUpdateMenu();
			menu = nextInt();
			runStudentUpdateMenu(menu);
		}while(menu != 5);
	}

	private void printStudentUpdateMenu() {
		System.out.print(
				  "학생 수정 메뉴\n"
				+ "1. 학생 정보 수정\n"
				+ "2. 성적 추가\n"
				+ "3. 성적 수정\n"
				+ "4. 성적 삭제\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}

	private void runStudentUpdateMenu(int menu) {
		switch(menu) {
		case 1:
			studentInfoUpdate();
			break;
		case 2:
			scoreInsert();
			break;
		case 3:
			scoreUpdate();
			break;
		case 4:
			scoreDelete();
			break;
		case 5:
			prev();
			break;
		default:
			
		}
	}

	private void studentInfoUpdate() {
		
	}

	private void scoreInsert() {
		System.out.println("성적을 입력할 학생의 정보를 입력하세요.");
		Student std = inputStudent();
		int stdIndex = list.indexOf(std);
		
		if(stdIndex < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("성적을 입력할 과목을 입력하세요.");
		Subject sub = inputSubject();
		
		int subIndex = list.get(stdIndex).getSubjectList().indexOf(sub);
		
		if(subIndex < 0) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		
	}


	private void scoreUpdate() {
		
	}

	private void scoreDelete() {
		
	}

	private void studentDelete() {
		Student std = inputStudent();
		
		if(list.remove(std)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}	
		
		System.out.println("일치하는 학생이 없습니다.");
	}

	private void studentSearch() {
		Student std = inputStudent();

		int index = list.indexOf(std);

		if(index < 0) {
			std = null;
		}
		else {
			std = list.get(index);
		}
		
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		std.print();
	}

	private void prev() {
		System.out.println("이전 메뉴로 돌아갑니다.");
		return;
	}

	private void subject() {
		int menu;
		do {
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu(menu);
		}while(menu != 5);
	}

	private void printSubjectMenu() {
		System.out.print(
				  "과목 관리 메뉴\n"
				+ "1. 과목 추가\n"
				+ "2. 과목 수정\n"
				+ "3. 과목 삭제\n"
				+ "4. 과목 확인\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
	}

	private void runSubjectMenu(int menu) {
		switch(menu) {
		case 1:
			subjectInsert();
			break;
		case 2:
			subjectUpdate();
			break;
		case 3:
			subjectDelete();
			break;
		case 4:
			subjectSearch();
			break;
		case 5:
			prev();
			break;
		default:
			
		}
	}

	private void subjectInsert() {
		Subject sub = inputSubject();
		
		if(subjectList.contains(sub)) {
			System.out.println("이미 등록된 과목명, 학년, 학기입니다.");
			return;
		}
		
		subjectList.add(sub);
		System.out.println("과목이 추가되었습니다.");
	}
	/**과목명, 학년, 학기를 입력받아 과목 객체를 만들어서 반환하는 메소드
	 * @return 과목명, 학년, 학기가 있는 만들어진 과목 객체
	 * */
	public Subject inputSubject() {
		System.out.print("과목명 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("학기 : ");
		int semester = nextInt();
		
		return new Subject(name, grade, semester);
	}

	private void subjectUpdate() {
		
	}

	private void subjectDelete() {
		Subject sub = inputSubject();
		
		if(subjectList.remove(sub)) {
			System.out.println("과목을 삭제했습니다.");
			return;
		}
		
		System.out.println("일치하는 과목이 없습니다.");
	}

	private void subjectSearch() {
		Subject sub = inputSubject();
		
		int index = subjectList.indexOf(sub);
		
		if(index < 0) {
			sub = null;
		}
		else {
			sub = subjectList.get(index);
		}
		
		if(sub == null) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		sub.print();
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
		return;
	}

}
