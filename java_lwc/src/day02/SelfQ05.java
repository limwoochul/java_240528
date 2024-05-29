package day02;

public class SelfQ05 {

	public static void main(String[] args) {
		//반복문 사용해서 모양 만들어보기 2
		
		int linenum = 7;
		int starnum = 1;
		int spacenum = linenum / 2;
		
		for(int i = 0; i < linenum; i++) {
			for(int j = 0; j < spacenum; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < starnum; j++) {
				System.out.print("*");
			}
			for(int j = 0; j < spacenum; j++) {
				System.out.print(" ");
			}
			if(i < 3) {
				spacenum -= 1;
				starnum += 2;
			}
			else {
				spacenum += 1;
				starnum -= 2;
			}
			System.out.println("");
		}
	}

}
