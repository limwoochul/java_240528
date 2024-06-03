package day05;

public class SelfEx12 {

	public static void main(String[] args) {

		//구구단 출력하기
		
		for(int i=1; i<10; i++) {
			System.out.println("====" + i + "단====");
			for(int j=1; j<10; j++) {
				System.out.print(i + "X" + j + "=" + i*j + "\t");
				if(j%3==0) {
					System.out.println();
				}
			}
			System.out.println();
		}
		
	}

}
