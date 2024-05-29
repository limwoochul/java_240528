package day02;

public class SelfQ02 {

	public static void main(String[] args) {
		
		//구구단을 짝수 단만 출력하도록 프로그램을 만들어 보세요.
		
		for(int dan = 1; dan <= 9; dan++) {
			if(dan % 2 == 1)
				continue;
			System.out.println("===" + dan + "단===");
			for(int times = 1; times <= 9; times++) {
				System.out.println(dan + " * " + times + " = " + dan*times);
			}
			System.out.println("");
		}
	}

}
