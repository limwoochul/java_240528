package day07;

import java.util.Arrays;
import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/* 최대 단어 10개를 저장할 수 있는 배열을 이용하여
		 * 원하는 단어를 입력하면 단어를 배열에 추가하는 코드를 작성하세요.
		 * 
		 * 단어 입력 (종료:-1) : cat
		 * 단어를 추가했습니다.
		 * 단어 입력 (종료:-1) : dog
		 * 단어를 추가했습니다.
		 * ...
		 * 단어 입력 (종료:-1) : good
		 * 단어를 추가하지 못했습니다.
		 * 단어 입력 (종료:-1) : -1
		 * 종료합니다. 
		 * */
		
		Scanner scan = new Scanner(System.in);
		String[] arr = new String[10];
		String word;
		int count=0;
			
		while(true) {
			System.out.print("단어 입력 (종료:-1) : ");
			word = scan.next();
			
			if(word.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
						
			
			if(count == arr.length){
				System.out.println("단어를 추가하지 못했습니다.");
			}	
			else{
				arr[count++] = word; 
				System.out.println("단어를 추가했습니다.");
			}
						
		}

	}

}
