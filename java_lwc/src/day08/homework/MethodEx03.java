package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx03 {

	/* 배열에 랜덤으로 1~9사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드를 작성하세요.
	 * 단 메서드 이용
	 * day08.homework.MethodEx01, day08.homework.MethodEx02, day08.MethodEx05를 합친 예제 
	 * */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		int[] arr = list(num);
		if(arr == null) {
			System.out.println("잘못된 입력입니다.");
		}
		else {
			System.out.println(Arrays.toString(arr));
		}
		
		

	}
	
	
	/**기능 : 배열의 크기를 입력받아 1~9 사이의 중복되지 않은 수들을 배열에 저장하기
	 * 매개변수 : int num
	 * 리턴타입 : int[]
	 * 매서드명 : list
	 * */
	
	public static int[] list(int num) {
		
		if(num>9 || num<=0) {
			return null;
		}
		
		int[] list = new int[num];
		int min=1, max=9, count=0, random, i;
		
		while(count<list.length) {
			random = (int)(Math.random()*(max-min+1)+min);
			
			for(i=0; i<count; i++) {
				if(list[i] == random) {
					break;
				}
			}
			
			if(i == count) {
				list[count++] = random;
			}
		}
		
		
		return list;
	}

}
