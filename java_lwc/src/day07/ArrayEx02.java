package day07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 3명의 학생의 국어, 영어, 수학 성적을 입력받고 
		 * 각 학생의 평균을 구하는 코드를 작성하세요.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int[] kor, eng, math;
		int studentCount = 3;
		kor = new int[studentCount];
		eng = new int[studentCount];
		math = new int[studentCount];
		double[] avg = new double[studentCount];
		
		System.out.println("각 학생의 국어, 영어, 수학 성적을 순서대로 입력하세요(예: 80 70 100)");
		for(int i=0; i<studentCount; i++) {
			System.out.print("학생" + (i+1) + "의 성적 : ");
			kor[i] = scan.nextInt();
			eng[i] = scan.nextInt();
			math[i] = scan.nextInt();
			avg[i] = (kor[i] + eng[i] + math[i])/(double)3;
		}
		
		System.out.println("\n==각 학생의 평균==");
		for(int i=0; i<studentCount; i++) {
			System.out.println("학생" + (i+1) + "의 평균은 " + avg[i] + "점 입니다.");
		}
		
		//각 과목의 평균을 구하는 코드
		
		int korSum=0, engSum=0, mathSum=0;
		
		for(int i=0; i<3; i++) {
			korSum += kor[i];
			engSum += eng[i];
			mathSum += math[i];
		}
					
		double korAvg, engAvg, mathAvg;
		korAvg = korSum/(double)3;
		engAvg = engSum/(double)3;
		mathAvg = mathSum/(double)3;
		
		System.out.println("\n==각 과목의 평균==");
		System.out.println("국어 성적의 평균은 " + korAvg + "점 입니다.");
		System.out.println("영어 성적의 평균은 " + engAvg + "점 입니다.");
		System.out.println("수학 성적의 평균은 " + mathAvg + "점 입니다.");
		
	}

}
