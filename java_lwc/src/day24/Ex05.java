package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		/* 문자열을 입력받아 exit가 아니면 입력한 문자열을 출력하고, exit이면 종료하는 코드를 작성하려고 했다.
		 * 원인 : 
		 * 1. while의 조건문에서 false가 들어갔기 때문에 애초에 실행되지 않는다.
		 * 2. true 조건으로 시작했다고 하더라도 무한루프에 빠져서 exit를 입력하더라도 반복문이 종료되지 않는다.
		 * 3. str은 문자열이기 때문에 str == "exit"라는 조건 대신 str.equals("exit")라고 입력하는게 옳다.
		 * 4. 반복문을 종료하기 위해서는 continue; 가 아니라 break;를 사용해 빠져나와야 한다.
		 * 해결방법 : res-> true로 바꾸기 / if(str.equals("exit") break; 로 바꾸기
		 * */
		
		Scanner scan = new Scanner(System.in);
		boolean res = false;
		while(res) {
			System.out.print("문자열 입력 : ");
			String str = scan.next();
			if(str == "exit") {
				continue;
			}
			System.out.println(str);
		}

	}

}
