package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 1 성적 입력 : ");
		int score1 = scan.nextInt();
		System.out.print("학생 2 성적 입력 : ");
		int score2 = scan.nextInt();
		System.out.print("학생 3 성적 입력 : ");
		int score3 = scan.nextInt();
		
		int sum = score1 + score2 + score3;
		double avr = sum / (double)3;
		
		System.out.println("총점 : " + sum + "점. 평균 : " + avr);
		
		
	}

}
