package day22;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01 {

	public static void main(String[] args) {
		/* 콘솔에서 한 문장(영어)을 입력하고 한 문장에 몇 개의 단어로 구성되어 있는지
		 * 확인하는 코드를 작성하세요.
		 * Hi My name is Hong Hi -> 6개
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문장 입력 : ");
		String sentence = scan.nextLine().trim();
		
		int wordCount = 1;
		
		for(int i=0; i<sentence.length(); i++) {
			if(sentence.charAt(i) == ' ' && sentence.charAt(i+1) == ' ') continue;
			if(sentence.charAt(i) == ' ') wordCount++;
		}
		
		System.out.println("단어의 개수 : " + wordCount);

		//강사님 방법
		System.out.print("문장 입력 : ");
		String str = scan.nextLine();
		String [] words = str.split(" ");
		System.out.println("단어의 개수 : " + words.length);
		
		//강사님 방법2
		StringTokenizer st = new StringTokenizer(str, " ");
		int count = 0;
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			count++;
		}
		System.out.println("단어의 개수 : " + count);
		
	}

}
