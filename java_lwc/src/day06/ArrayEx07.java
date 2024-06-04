package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		/* UpDown 게임에 다음 기능을 추가하세요.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴선택 : 1
		 * (랜덤이 35라고 가정)
		 * 정수 입력 : 50
		 * Down!
		 * 정수 입력 : 30
		 * Up!
		 * 정수 입력 : 35
		 * 정답입니다.
		 * 맞힌 횟수는 3회입니다.
		 * 기록이 등록됩니다.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴선택 : 2
		 * 기록확인
		 * 1. 3회
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴선택 : 3
		 * 프로그램을 종료합니다.
		 * */
		
		//변수 선언
		
		//선택한 메뉴가 3이 아닐 때 실행되는 반복문
		
			//메뉴 출력
		
			//Scanner를 이용하여 메뉴를 입력
		
			//선택한 메뉴에 따른 기능 실행
			//선택한 메뉴가 1이면 플레이 문구 출력하는 코드 작성(게임 플레이하는 코드 작성)
		
			//선택한 메뉴가 2이면 기록 확인 문구 출력하는 코드 작성(기록 확인하는 코드 작성)
		
			//선택한 메뉴가 3이면 프로그램 종료 문구 출력하는 코드 작성
		
			//아니면 잘못된 메뉴 문구 출력하는 코드 작성
		
		
		
		
		Scanner scan = new Scanner(System.in);
		int menu, min=1, max=100, random,num, count;
		int[] record = new int[5];
		int recordCount=0;
		
		System.out.println("==UpDown 게임을 시작합니다!==");
		do {
			System.out.println("==메뉴==");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			
			//1.플레이
			case 1:
				random = (int)(Math.random()*(max - min + 1) + min);
				System.out.println("(점검용)랜덤한 수 : " + random);
				count = 0;
				
				do {
					System.out.print("정수 입력 : ");
					num = scan.nextInt();
					if(num < random && num>=1) {
						System.out.println("UP!");
						count++;
					}
					else if(num > random && num<=100) {
						System.out.println("DOWN!");
						count++;
					}
					else if(num == random) {
						System.out.println("정답입니다!");
						count++;
						System.out.println("맞힌 횟수는 " + count + "회 입니다.");
						System.out.println("기록이 등록됩니다.");
					}
					else {
						System.out.println("잘못된 입력입니다.");
					}		
				}while(random != num);
				//기록의 개수가 5개 미만이면
					//기록을 등록
					//recordCount번지에 저장하고 recordCount를 1 증가
				
				//아니면 내 기록이 5등보다 좋은지 비교해서 좋으면
					//기록을 등록
					//마지막번지에 내 기록을 등록
				
				//기록 정렬
				//Arrays.sort를 이용하여 0번지부터 recordCount번지전까지 정렬
				//0번지는 포함, recordCount번지는 포함을 안하고 앞 번지까지
				
				if(recordCount < 5) {
					record[recordCount++] = count;
				}
				else if(record[recordCount-1] > count) {
					record[recordCount-1] = count;
				}
				Arrays.sort(record, 0, recordCount);
				//System.out.println(Arrays.toString(record));
				break;
				
				/*
				for(int i=0; i<rank.length-1; i++) {
					if(rank[i] == 0) {
						rank[i] = count;
						break;
					}
				}
				if(recordTimes < 5) {
					Arrays.sort(rank,0,recordTimes);							
				}
				else {
					rank[rank.length-1] = count;
					Arrays.sort(rank);
				}
				*/
				
			
			
			//2. 기록 확인
			case 2:
				System.out.println("기록확인");
				if(recordCount==0) {
					System.out.println("등록된 기록이 없습니다.");
					break;
				}
				for(int i=0; i<recordCount; i++) {
					System.out.println((i+1) + ". " + record[i] + "회");
				}
				break;
			
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			
			//1,2,3 이외의 다른 수를 입력했을 때
			default:
				System.out.println("잘못된 메뉴입니다.");

			}
		}while(menu != 3);//종료
		
		
		
		
		
		
		
		
		
		
	}

}
