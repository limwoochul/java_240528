package day15;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex05Self2 {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요. 
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있고 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우 */
		
		//중복되지 않은 1~9 사이의 3개의 숫자를 생성
		int min = 1, max = 9, count = 3;
		List<Integer> com = getRandom(min, max, count);
		
		//System.out.println(com); //체크
		
		int strike, ball;
		int gameCount = 0;
		Scanner scan = new Scanner(System.in);
		List<Integer> user;
		//반복문
		do {
			strike = ball = 0;
			gameCount++;
			//사용자가 숫자 3개를 중복되지 않게 1~9사이의 값을 입력
			System.out.print("숫자 입력 : ");
			user = inputUser(min, max, count, scan);
			//System.out.println(user);
			//입력한 값과 랜덤 값을 이용하여 결과를 출력
			strike = getStrike(com, user);
			ball = getBall(com, user);
			
			if(strike != 0) {
				System.out.print(strike + "S ");
			}
			
			if(ball != 0) {
				System.out.print(ball + "B");
			}
			
			if(strike == 0 && ball == 0) {
				System.out.print("O");
			}
			
			System.out.println();
			
		}while(strike != 3);
		System.out.println(gameCount + "회 만에 맞추셨습니다.");
		System.out.println("프로그램을 종료합니다.");

	}

	private static int getBall(List<Integer> com, List<Integer> user) {
		if(com.size() != user.size()) {
			throw new RuntimeException("크기가 달라 비교할 수 없습니다.");
		}
		int ball = 0;
		for(int tmp : com){
			if(user.contains(tmp)) ball++;
		}
		return ball - getStrike(com, user);
	}

	private static int getStrike(List<Integer> com, List<Integer> user) {
		if(com.size() != user.size()) {
			throw new RuntimeException("크기가 달라 비교할 수 없습니다.");
		}
		int strike = 0;
		for(int i=0; i<com.size(); i++) {
			if(com.get(i) == user.get(i)) strike++;
		}
		return strike;
	}

	private static List<Integer> inputUser(int min, int max, int count, Scanner scan) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(max-min+1 < count) {
			String format = "{0}~{1}사이의 중복되지 않은 수를 {2}개 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min, max, count));
		}
		
		List<Integer> user = new ArrayList<Integer>();
		while(user.size() < count) {
			int num = scan.nextInt();
			if(!user.contains(num)) {
				user.add(num);
			}
		}
		return user;
	}

	private static List<Integer> getRandom(int min, int max, int count) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(max-min+1 < count) {
			String format = "{0}~{1}사이의 중복되지 않은 수를 {2}개 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min, max, count));
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < count) {
			int r = (int)(Math.random()*(max-min+1)+min);
			set.add(r);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		
		Collections.shuffle(list);
				
		return list;
	}

}
