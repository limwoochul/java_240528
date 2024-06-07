package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요.
		 * 규칙
		 * - 중복되지 않은 1~9 사이의 랜덤한 수를 생성
		 * - 스트라이크 : 해당 숫자가 있고, 위치도 같은 경우
		 * - 볼 : 숫자가 있지만 위치가 다른 경우
		 * - 아웃 : 일치하는 숫자가 하나도 없는 경우 
		 * 예시
		 * (3 9 7)
		 * 입력 : 1 2 3
		 * 1B
		 * 입력 : 5 6 7
		 * 1S
		 * 입력 : 4 5 6
		 * O
		 * 입력 : 3 7 9
		 * 1S2B
		 * 입력 : 3 9 7
		 * 3S
		 * 정답입니다.
		 * */
		
		//랜덤한 수를 생성(중복되지 않게 1~9 사이의 3개의 수)
		
		//반복문을 이용하여 정수 3개를 입력 받은 후 판별(다 맞출 때까지)
		
			//입력 안내문구 출력
			
			//3개를 입력
		
			//결과 판별 후 출력
			//첫번째 랜덤수와 첫번째 입력값이 같으면 스트라이크 또는 볼로 판별
		
			//첫번째 랜덤수와 두번째 입력값이 같으면 스트라이크 또는 볼로 판별
		
			//첫번째 랜덤수와 첫번째 입력값이 같으면 스트라이크 또는 볼로 판별
		
		
		
		
		
		Scanner scan = new Scanner(System.in);
		
		int min=1,max=9, random, count=0, i;
		int[] arr, num;
		arr = new int[3];
		num = new int[3];
		
		
		while(count < arr.length) {
			random = (int)(Math.random()*(max-min+1)+min);
			
			for(i = 0; i < count; i++) {
				if(arr[i] == random) {
					break;
				}
			}
			
			if(i == count) {
				arr[count++] = random;
			}
		}
		System.out.println("(점검용) : " + Arrays.toString(arr));
		
		
		int strike, ball;
		do{
			strike=0;
			ball=0;
			
			System.out.print("번호 입력 : ");
			for(int j=0; j<num.length; j++) {
				num[j] = scan.nextInt();
			}
			
			for(int j=0; j<num.length; j++) {
				if(num[j]==arr[j]) {
					strike++;
				}
				for(int k=0; k<arr.length; k++) {
					if(j==k) {
						continue;
					}
					
					if(num[j] == arr[k]) {
						ball++;
					}
				}
			}
			
			
			
			if(strike==0 && ball ==0) {
				System.out.println("O");
			}
			else if(ball == 0) {
				System.out.println(strike + "S");
			}
			else if(strike ==0) {
				System.out.println(ball + "B");
			}
			else {
				System.out.println(strike + "S" + ball + "B");
			}
			
			
		}while(strike != 3);
		
		System.out.println("정답입니다!");
		
		

	}

}
