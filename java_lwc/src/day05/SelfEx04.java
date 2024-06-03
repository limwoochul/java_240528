package day05;

public class SelfEx04 {

	public static void main(String[] args) {
		// 221쪽

		char[][] alphabets = new char[13][2];
		char ch = 'a';
		
		for(int i = 0; i < alphabets.length; i++) {
			for(int j = 0; j <alphabets[0].length; j++, ch++) {
				alphabets[i][j] = ch;
				System.out.print(alphabets[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
