package day09;

public class ClassEx02 {

	public static void main(String[] args) {
		Student2 std = new Student2();
		std.setGrade(1);
		std.setClassNum(1);
		std.setNum(1);
		std.setName("홍길동");
		
		System.out.println(std.getGrade() + "학년 " + std.getClassNum() + "반 " + std.getNum() + "번 " + std.getName());
	}

}


class Student2{
	private int grade, classNum, num;
	private String name;
	//grade에 대한 getter
	public int getGrade() {
		return grade;
	}
	//grade에 대한 setter
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
}