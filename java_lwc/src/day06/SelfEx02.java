package day06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SelfEx02 {

	public static void main(String[] args) {
		//UpDown게임 복습
		
		int menu, random, num, count;
		int min=1, max=100;
		int[] record = new int[5];
		int recordCount = 0;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("==UpDown게임을 시작합니다.==");
		do {
			System.out.println("==메뉴==");
			System.out.println("1. 플레이");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 입력 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.println(min + "~"+ max +" 사이의 숫자를 맞춰보세요!");
				random =(int)(Math.random()*(max-min+1)+min);
				System.out.println("(점검용) 랜덤한 수 : " + random);
				count = 0;
				
				do {
					System.out.print("정수 입력 : ");
					num = scan.nextInt();
					if(num < random) {
						System.out.println("UP!");
						count++;
					}
					else if(num > random){
						System.out.println("DOWN!");
						count++;
					}
					else if(num == random) {
						System.out.println("정답입니다!");
						count++;
						System.out.println("정답을 " + count + "회 만에 맞추셨습니다.");
						System.out.println("기록이 등록됩니다.");
					}
					else {
						System.out.println("잘못된 입력입니다.");
					}
				}while(num != random);
				
				if(recordCount < 5) {
					record[recordCount++] = count;
				}
				else if(record[recordCount-1] > count) {
					record[recordCount-1] = count;
				}
				Arrays.sort(record,0,recordCount);
				break;
				
			case 2:
				System.out.println("기록확인");
				if(recordCount == 0) {
					System.out.println("등록된 기록이 없습니다.");
				}
				for(int i=0; i<recordCount; i++) {
					System.out.println((i+1) + ". " + record[i] + "회");
				}
				break;
			
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
				System.out.println("잘못된 메뉴입니다.");
			
			}
		}while(menu != 3);

	}

}
