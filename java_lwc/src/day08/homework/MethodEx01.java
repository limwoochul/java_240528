package day08.homework;

import java.util.Scanner;

public class MethodEx01 {

	/* 정수 n을 입력받아 입력받은 n 크기를 가지는 배열을 생성하는 코드를 작성하세요.
	 * 메서드를 이용 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		int[] arr = list(num);
		
		System.out.println("배열의 크기 : " + arr.length);

	}
	
	/**기능 : n을 입력받아 n만큼의 크기를 가지는 배열 생성하기
	 * 매개변수 : int n
	 * 리턴타입 : int[]
	 * 매서드명 : list
	 * */
	public static int[] list(int n) {
		
		int[] list = new int[n];
		
		return list;
	}

}
