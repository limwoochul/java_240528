package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/* 4 과목의 성적을 입력받아 배열에 저장하고, 과락이 없고 평균이 60점이 넘으면 Pass, 아니면 Fail이라고 출력
		 * */
		
		//4개짜리 배열 생성
		
		//성적 4개 입력
		
		/* 입력받은 성적의 총합을 계산
		 * 반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 * 실행문 : 배열에서 가져온 값을 sum에 누적
		 * 반복문 종료 후 : 없음
		 * */
		
		//입력받은 성적의 총합을 계산
		
		//총합을 이용하여 평균을 계산
		
		/* 과락여부 확인하여 변수에 저장
		 * 반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 * 실행문 : 배열에서 가져온 값이 40보다 작으면 과락 변수를 true로 변경
		 * 반복문 종료 후 : 없음
		 * */
		
		//과락이 아니고 평균이 60 이상이면 Pass,
		
		//아니면 Fail
		

		int[] score = new int[4];
		Scanner scan = new Scanner(System.in);
		int sum =0;
		
		System.out.println(score.length + "개 과목의 성적 입력하기(0~100점)");
		for(int i=0; i<score.length; i++) {
			do {
			System.out.print((i+1) + "과목 성적 입력 : ");
			score[i] = scan.nextInt();
				if(score[i]>=0 && score[i]<=100) {
					break;
				}
				else {
					System.out.println("잘못된 입력입니다.");
				}
			}while(score[i]<0 || score[i] > 100);
			sum += score[i];
		}//점수받고 총점내기
		double avg = sum / (double)score.length;//평균내기
		
		
		boolean isFail = false;
		Arrays.sort(score); //배열 오름차순 정리
		if(score[0]<40) {
			isFail = true;
		}//최저점이 과락인지 확인
		
		
		/*for(int i=0; i<score.length; i++) {
			if(score[i] < 40) {
				isFail = true;
				break;
			}
		}//과락 검사
		*/

		System.out.println("\n ====점검하기====");
		System.out.println("1. 과락이 있습니까? " + isFail);
		System.out.println("2. " + score.length + "개 과목의 평균 : " + avg + "\n");
		
		
		if(avg<60 || isFail) {
			System.out.println("최종 결과 : Fail");
		}
		else {
			System.out.println("최종 결과 : Pass");
		}
		
		
		
	}

}
