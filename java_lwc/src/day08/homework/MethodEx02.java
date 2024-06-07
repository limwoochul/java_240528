package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx02 {

	/* 1~9 사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는 코드를 작성하세요.
	 * 메서드 이용
	 * */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		int[] arr = list(num);
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	/**기능 : 배열의 크기를 입력받아 1~9 사이 랜덤한 수를 배열에 저장하기 
	 * 매개변수 : int num
	 * 리턴타입 : int[]
	 * 매서드명 : list
	 * */
	
	public static int[] list(int num) {
		int[] list = new int[num];
		int min=1, max=9;
		
		for(int i=0; i<num; i++) {
			list[i] = (int)(Math.random()*(max-min+1)+min);
		}
		
		return list;
	}
	
}
