package day02;

public class SelfEx {

	public static void main(String[] args) {

		for(int dan = 2; dan <= 9; dan++){
			if(dan % 2 == 0)
				continue;
			System.out.println("===" + dan + "단===");
			for(int times = 1; times <= 9; times++) {
				System.out.println(dan + " * " + times + " = " + dan*times);
			}
			System.out.println("");
		}
	}

}
