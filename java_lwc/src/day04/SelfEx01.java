package day04;

public class SelfEx01 {

	private static int serialNum = 1000;
	int studentID;
	String studentName;
	int grade;
	String adrress;
	int cardNumber;
	
	public SelfEx01() {
		serialNum++;
		studentID = serialNum;
		cardNumber = studentID + 100;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}
	
	public static int getSerialNum() {
		return serialNum;
	}
	
	public static void setSerialNum(int serialNum) {
		SelfEx01.serialNum = serialNum;
	}
	
	
}
