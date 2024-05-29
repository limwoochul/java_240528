package day02;

public class SelfQ03 {

	public static void main(String[] args) {
		
		//구구단을 단보다 곱하는 수가 작거나 같은 경우까지만 출력하는 프로그램을 만들어 보세요.
		
		for(int dan = 1; dan < 10; dan++) {
			System.out.println("===" + dan + "단===");
			for(int times = 1; times <= dan; times++) {
				System.out.println(dan + " * " + times + " = " + dan*times);
			}
			System.out.println("");
		}
	}

}
