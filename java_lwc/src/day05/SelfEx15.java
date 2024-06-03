package day05;

import java.util.Scanner;

public class SelfEx15 {

	public static void main(String[] args) {
		//1~10까지 랜덤한 수를 저장하고 출력
		//숫자를 입력해서 저장한 수가 있는지 확인
		
		int[] arr = new int[3];
		int min = 1, max = 10;
		
		System.out.print("랜덤 수 3가지 : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//숫자입력
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = scan.nextInt();
				
		//숫자 확인 방법1
		int i;
		for(i=0; i<arr.length; i++) {
			if(num == arr[i]) {
				break;
			}
		}
		if(i < arr.length) {
			System.out.println("방법1 : " + num + "은(는) 있습니다.");
		}
		else {
			System.out.println("방법1 : " + num + "은(는) 없습니다.");
		}
		
		//숫자 확인 방법2
		boolean result = false;
		for(int tmp : arr) {
			if(tmp == num) {
				result = true;
			}
		}
		
		if(result) {
			System.out.println("방법2 : " + num + "은(는) 있습니다.");
		}
		else {
			System.out.println("방법2 : " + num + "은(는) 없습니다.");
		}
		
		
		

	}

}
