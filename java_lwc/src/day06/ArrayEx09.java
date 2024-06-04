package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		String[] list = {"dog", "cat", "java", "cup", "computer"};
		
		//문자열을 입력받아 문자열이 있는지 없는지 알려주는 코드를 작성하세요.
		
		Scanner scan = new Scanner(System.in);
		boolean isSame;
		
		
		do {
			isSame = false;
			System.out.print("문자열 입력 : ");
			String str = scan.next();
			
			for(int i=0; i<list.length; i++) {
				if(str.equals(list[i])) {
					isSame =true;
					break;
				}
			}
			
			if(isSame) {
				System.out.println(str + "은(는) 있습니다.");
			}
			else {
				System.out.println(str + "은(는) 없습니다.");
			}
			
		}while(!isSame);

	}

}
