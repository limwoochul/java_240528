package day05;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 학생 3명의 성적을 저장하는 배열을 생성하고,
		 * 학생 3명의 성적을 콘솔을 통해 입력받고,
		 * 입력받은 성적의 평균을 구하는 코드를 작성하세요.
		 * */
		
		int[] score = new int[3];
		double sum = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학생의 성적을 입력하세요.");	

		for(int i = 0; i < score.length; i++) {
			System.out.print("학생 " + (i+1) + " : ");
			score[i] = scan.nextInt();
			sum += score[i];
		}
		
		for(int i = 0; i < score.length; i++) {
			System.out.println("학생 " + (i+1) +"의 성적 : " + score[i]);
		}
		
		double avg = sum / (double)score.length;
		
		System.out.println("학생" + score.length + "명의 평균 : " + avg);
		
	}

}
