package day03;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int score;
		
		System.out.print("성적을 입력하세요 : ");
		score = scan.nextInt();
		
		if(score >= 90 && score <= 100){
			System.out.println(score + "점은 A 학점입니다.");
		}
		else if(score >= 80 && score < 90) {
			System.out.println(score + "점은 B 학점입니다.");
		}
		else if(score >= 70 && score < 80) {
			System.out.println(score + "점은 C 학점입니다.");
		}
		else if(score >= 60 && score < 70) {
			System.out.println(score + "점은 D 학점입니다.");
		}
		else if(score >= 0 && score < 60) {
			System.out.println(score + "점은 F 학점입니다.");
		}
		else {
			System.out.println("잘못된 성적입니다.");
		}
		
	}

}
