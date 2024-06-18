package Day15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ex04Self {

	public static void main(String[] args) {
		/* 1~45 사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고,
		 * 사용자가 번호를 6개 입력해서 몇등인지 맞추는 로또 예제
		 * 1등 : 번호 6개가 일치
		 * 2등 : 번호 5개와 보너스 번호 일치
		 * 3등 : 번호 5개가 일치
		 * 4등 : 번호 4개가 일치
		 * 5등 : 번호 3개가 일치
		 * 나머지는 꽝 */
		
		//로또 번호와 보너스 번호를 생성
		
		//사용자가 6개의 번호를 입력
		
		//입력한 번호를 이용하여 당첨 등수를 출력

		Scanner scan = new Scanner(System.in);
		HashSet<Integer> lotto = new HashSet<Integer>();
		int min = 1, max = 45;
		int random;
		
		while(lotto.size() < 6) {
			random = (int)(Math.random()*(max-min+1)+min);
			lotto.add(random);
		}
		
		int bonus;
		do{
			bonus = (int)(Math.random()*(max-min+1)+min);
		}while(lotto.contains(bonus));
		
		System.out.println("당첨번호 : " + lotto);
		System.out.println("보너스 번호 : " + bonus);
		
		System.out.print("6개 번호 입력 (예시 : 4 15 20 33 36 41) : ");
		int[] user = new int[6];
		int count = 0, bonusCheck = 0;
		
		for(int i=0; i<user.length; i++) {
			user[i] = scan.nextInt();
			if(lotto.contains(user[i])) count++;
			if(user[i] == bonus) bonusCheck++;
		}
			
		switch(count) {
		
		case 3:
			System.out.println("결과 : 5등입니다.");
			break;
			
		case 4:
			System.out.println("결과 : 4등입니다.");
			break;
			
		case 5:
			if(bonusCheck == 0) {
				System.out.println("결과 : 3등입니다.");
				break;
			}
			System.out.println("결과 : 2등입니다.");
			break;
			
		case 6:
			System.out.println("결과 : 1등입니다.");
			break;
			
		default:
			System.out.println("결과 : 낙첨입니다.");
		
		}
		
		
	}

}
