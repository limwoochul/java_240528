package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex05Self {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요. 
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있고 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우 */
		
		//중복되지 않은 1~9 사이의 3개의 숫자를 생성
		
		//반복문
		
			//사용자가 숫자 3개를 중복되지 않게 1~9사이의 값을 입력
		
			//입력한 값과 랜덤 값을 이용하여 결과를 출력
		
		ArrayList<Integer> baseBall = new ArrayList<Integer>();
		
		int min = 1, max = 9;
		
		while(baseBall.size() < 3) {
			int random = (int)(Math.random()*(max-min+1)+min);
			if(baseBall.contains(random)) continue;
			baseBall.add(random);	
		}
		
		//System.out.println(baseBall); // 체크
		
		int strike, ball;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> user = new ArrayList<Integer>();
		do {
			user.clear();
			System.out.print("번호 입력 : ");
			while(user.size() < 3) {
				user.add(scan.nextInt());
			}
			strike = 0;
			ball = 0;
			count ++;
			
			for(int i=0; i<3; i++) {
				if(user.get(i) == baseBall.get(i)) strike++;
				
				for(int j=0; j<3; j++) {
					if(i == j) continue;
					if(user.get(i) == baseBall.get(j)) ball++;
				}
			}
			
			if(strike == 0 && ball == 0) {
				System.out.println("O");
			}
			else if(strike == 0) {
				System.out.println(ball + "B");
			}
			else if(ball == 0) {
				System.out.println(strike + "S");
			}
			else {
				System.out.println(strike + "S " + ball + "B");
			}
			
			
		}while(strike != 3);
		System.out.println("정답입니다!");
		System.out.println(count + "회 만에 정답을 맞추셨습니다.");

	}

}
