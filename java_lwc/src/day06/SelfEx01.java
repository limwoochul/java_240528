package day06;

import java.util.Scanner;

public class SelfEx01 {

	public static void main(String[] args) {

		int[] arr = new int[3];
		int min=1, max=10;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
		
		System.out.print("랜덤한 " + arr.length +"개의 정수 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//정수를 입력받아 배열 안에 있는지 확인
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
		//방법1
		int i;
		for(i=0; i<arr.length; i++) {
			if(num == arr[i]) {
				break;
			}
		}
		if(i < arr.length) {
			System.out.println("방법1 : " + num + "은 있습니다.");
		}
		else {
			System.out.println("방법1 : " + num + "은 없습니다.");
		}
		
		
		//방법2
		boolean result = false;
		for(int tmp : arr) {
			if(tmp == num) {
				result = true;
			}
		}
		
		if(result) {
			System.out.println("방법2 : " + num + "은 있습니다.");
		}
		else {
			System.out.println("방법2 : " + num + "은 없습니다.");
		}
		
		
		
	}

}
