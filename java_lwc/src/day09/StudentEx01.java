package day09;

import java.util.Scanner;

public class StudentEx01 {

	/* 학생 성적을 관리하기 위한 프로그램 예제 : 국어, 영어, 수학 */
	public static void main(String[] args) {
		
		/* 1. 다음 메뉴가 출력되도록 코드를 작성하세요.
		 * 메뉴
		 * 1. 학생 등록
		 * 2. 성적 수정
		 * 3. 성적 확인
		 * 4. 종료
		 * 메뉴 선택 :
		 * */
		
		/* 2. 메뉴를 출력하고 메뉴를 콘솔창에서 입력 받는 코드를 작성하세요.
		 * 단, 입력받은 메뉴가 4가 아니면 반복하도록 작성하세요. */
		
		/* 3. 입력한 메뉴가 1이면 학생 등록입니다. 2이면 성적 수정입니다. 3이면 성적 확인입니다. 4이면 프로그램 종료입니다.
		 * 라고 출력하도록 코드를 작성하세요.*/
		
		/* 4. 프로그램 관리를 위한 Student 클래스를 추가하세요.
		 * - 학년, 반, 번호, 이름, 국어, 영어, 수학
		 * - 멤버변수는 private으로 하고 getter/setter를 추가
		 * - 기본 생성자와 학년, 반, 번호, 이름을 이용한 생성자를 추가
		 * - 국어, 영어, 수학 성적을 변경하는 기능을 추가
		 * */
		
		/* 5. 학생 등록 기능을 구현하세요.
		 * 학년, 반, 번호, 이름을 입력받아 학생을 추가하세요.
		 * */
		
		Scanner scan = new Scanner(System.in);
		int menu;
		int grade, classNum, num, kor, eng, math, listNum;
		String name;
		//학생 배열
		Student[] list = new Student[10];
		int studentCount = 0; // 저장된 학생 수
		
		
		do {
			printMenu();
			menu = scan.nextInt();
			//학생 배열
			//runMenu(menu);
			switch(menu) {
			case 1:
				if(studentCount == list.length) {
					System.out.println("다 찼습니다.");
					break;
				}
				
				//학년, 반, 번호, 이름을 입력 받고
				System.out.print("학년 : ");
				grade = scan.nextInt();
				System.out.print("반 : ");
				classNum = scan.nextInt();
				System.out.print("번호 : ");
				num = scan.nextInt();
				System.out.print("이름 : ");
				name = scan.next();
				//입력받은 정보를 이용하여 학생 객체를 생성
				//배열이 꽉 차지 않으면 생성한 학생 객체를 배열에 저장하고				
				//저장된 학생 수를 1 증가
				list[studentCount++] = new Student(grade, classNum, num, name);
				for(Student tmp : list) {
					if(tmp != null) {
						System.out.println(tmp.getName());
					}
				}
				break;
			case 2:
				System.out.println("성적 수정입니다.");
				//학년, 반, 번호를 입력
				System.out.print("학년 : ");
				grade = scan.nextInt();
				System.out.print("반 : ");
				classNum = scan.nextInt();
				System.out.print("번호 : ");
				num = scan.nextInt();
				System.out.print("이름 : ");
				name = scan.next();
				//입력받은 학년, 반, 번호를 이용하여 일치하는 학생이 있는지 확인
				
				listNum = listNum(list, grade, classNum, num, name);
				//없다면 일치하는 학생이 없다고 출력하고 종료
				if(listNum == list.length) {
					System.out.println("일치하는 학생이 없습니다.");
					break;
				}
				//있다면 국어, 영어, 수학 성적을 입력받아 학생 성적을 수정
				else {
					System.out.println("일치합니다." + list[listNum].getName() + "학생의 수정된 성적을 입력하세요.");
					System.out.print("국어 : ");
					kor = scan.nextInt();
					System.out.print("영어 : ");
					eng = scan.nextInt();
					System.out.print("수학 : ");
					math = scan.nextInt();
					list[listNum].updateScore(kor, eng, math);
										
				}
				break;
			case 3:
				System.out.println("성적 확인입니다.");
				//학년, 반, 번호를 입력
				System.out.print("학년 : ");
				grade = scan.nextInt();
				System.out.print("반 : ");
				classNum = scan.nextInt();
				System.out.print("번호 : ");
				num = scan.nextInt();
				System.out.print("이름 : ");
				name = scan.next();
				//입력받은 학년, 반, 번호를 이용하여, 일치하는 학생이 있는지 확인
				listNum = listNum(list, grade, classNum, num, name);
				//없다면 일치하는 학생이 없다고 출력하고 종료
				if(listNum == list.length) {
					System.out.println("일치하는 학생이 없습니다.");
					break;
				}
				//있다면 해당 학생의 성적을 출력
				else {
					System.out.println("일치합니다." + list[listNum].getName() + "학생의 성적을 출력합니다.");
					System.out.println("국어 : " + list[listNum].getKor() + "점, 영어 : " + list[listNum].getEng() + "점, 수학 : " + list[listNum].getMath());
				}
				break;
			case 4:
				System.out.println("프로그램 종료입니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 4);
		

	}
	
	/**기능 : 메뉴를 출력하는 메소드
	 * */
	
	public static void printMenu() {		
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 확인");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 :");
	}
	
	/**기능 : 메뉴에 맞는 기능을 실행하는 메서드
	 * @param menu 실행할 메뉴
	 * */
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("학생 등록입니다.");
			break;
		case 2:
			System.out.println("성적 수정입니다.");
			break;
		case 3:
			System.out.println("성적 확인입니다.");
			break;
		case 4:
			System.out.println("프로그램 종료입니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	public static int listNum(Student[] list, int grade, int classNum, int num, String name) {
		if(list == null) return list.length;
	
		for(int i=0; i<list.length; i++) {
			if(list[i].getGrade() == grade && list[i].getClassNum() == classNum && list[i].getNum() == num && list[i].getName().equals(name)) {
				return i;
			}
		}
		return list.length;
	}

}

class Student{
	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;
	
	//getters와 setters
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	public Student(){}
	
	/**기능 : 국어, 영어, 수학 성적이 주어지면 변경하는 메서드
	 * @param kor 국어 성적
	 * @param eng 영어 성적
	 * @param math 수학 성적
	 * */
	
	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
}
