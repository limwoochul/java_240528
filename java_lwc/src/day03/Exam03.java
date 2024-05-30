package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("과목 1 성적 입력 : ");
		int score1 = scan.nextInt();
		System.out.print("과목 1 성적 입력 : ");
		int score2 = scan.nextInt();
		
		int sum = score1 + score2;
		double avg = (double)sum / 2;
		boolean isFail = score1 < 40 || score2 < 40;
		
		//String result1 = ( avg >= 60 && score1 >= 40 && score2 >= 40) ? "합격" : "불합격";
		String result2 = (avg >= 60 && !isFail) ? "합격" : "불합격";
		System.out.println("결과 : " + result2);
		
		
	}

}
