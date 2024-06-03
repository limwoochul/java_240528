package day05;

public class SelfEx03 {
	
	//211쪽

	public static void main(String[] args) {
		SelfEx02[] Student = new SelfEx02[3];
		
		Student[0] = new SelfEx02(1001, "James");
		Student[1] = new SelfEx02(1002, "Tomas");
		Student[2] = new SelfEx02(1003, "Edward");
		
		for(int i = 0; i < Student.length; i++) {
			Student[i].showStudentInfo();
		}

	}

}
