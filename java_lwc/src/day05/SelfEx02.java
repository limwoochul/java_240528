package day05;

public class SelfEx02 {
	
	//211쪽
	
	private int studentID;
	private String name;
	
	public SelfEx02() {}
	
	public SelfEx02(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
	}
	
	public int getstduentID() {
		return studentID;
	}
	
	public void setstudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void showStudentInfo() {
		System.out.println(studentID + ", " + name);
	}
	
}
