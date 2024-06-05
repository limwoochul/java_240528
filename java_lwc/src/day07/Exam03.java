package day07;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/* 입력한 문자열이 배열에 있는지 없는지 확인하는 코드를 작성하세요.
		 * 단어 입력 (종료:-1) : apple
		 * 없는 단어입니다.
		 * 단어 입력 (종료:-1) : cat
		 * 있는 단어입니다.
		 * 단어 입력 (종료:-1) : -1
		 * 종료합니다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		String [] list = new String[] {"cat", "dog", "banna"};
		String word;
		boolean result;
		
		while(true) {
			System.out.print("단어 입력 (종료:-1) : ");
			word = scan.next();
			
			if(word.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
			
			result = false;			
			for(String tmp : list) {
				if(tmp.equals(word)) {
					result = true;
					break;
				}
			}
			
			if(result) {
				System.out.println("있는 단어입니다.");
			}
			else {
				System.out.println("없는 단어입니다.");
			}
			
		}

	}

}
