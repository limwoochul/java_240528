package Day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* 전화번호를 5번 입력받아 리스트에 저장하는 코드를 작성하세요
		 * 단, 전화번호는 올바르게 입력했다고 가정. (정규표현식 사용하지 않아도됨) */

		ArrayList<String> list = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			System.out.print("전화번호 입력 : ");
			list.add(scan.next());
		}
		
		System.out.println(list);
		/* 삭제할 전화번호를 입력받아 삭제하는 코드는 작성하세요. */
		
		System.out.print("삭제할 전화번호 입력 : ");
		if(list.remove(scan.next())){
			System.out.println("삭제하였습니다.");
		}
		else {
			System.out.println("입력한 전화번호가 없습니다.");
		}
		System.out.println(list);
		
	}

}
