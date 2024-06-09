package day08.homework;

import java.util.Scanner;

public class MethodEx01 {

	/* 정수 n을 입력받아 입력받은 n 크기를 가지는 배열을 생성하는 코드를 작성하세요.
	 * 메서드를 이용 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//정수 입력
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		//입력받은 정수를 이용하여 정수 배열을 생성
		int[] arr = createArray(num);
		
		System.out.println("배열의 크기 : " + arr.length);

	}
	
	/**기능 : 배열의 크기가 주어지면 주어진 배열 크기의 정수 배열을 생성해서 알려주는 메서드
	 * 매개변수 : 배열 크기 => int n
	 * 리턴타입 : 생성된 정수 배열 => int[]
	 * 매서드명 : createArray
	 * */
	
	public static int[] createArray(int n) {
		
		int[] list = new int[n];
		
		return list;
	}

}
