package day05;

import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {
		//1~10사이의 랜덤한 수 3개를 저장하고 출력하는 예제
		
		int min=1, max=10;
		int[] arr = new int[3];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
		
		
		System.out.print("랜덤으로 정해진 숫자 " + arr.length + "개 출력 : ");
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//숫자를 입력해서 숫자가 랜덤한 수에 있는지 확인하는 예제
		//8을 입력하면 8은 없습니다. 라고 출력
		//2를 입력하는 2는 있습니다. 라고 출력
		
		//정수 입력
		
		Scanner scan = new Scanner(System.in);
		System.out.print("맞추고자 하는 정수 입력 ("+ min + "~"+max + ") : ");
		int num = scan.nextInt();

		/* 방법1
		 * 정수 3개가 있는데 내가 찾으려는 정수의 위치가 어딘지 확인.
		 * 중간에 찾았으면 1~3사이에 위치할테고 없으면 3보다 크다
		 * => 중간에 찾았으면 0~2번지 사이에 있을테고 없으면 번지가 3이다.
		 * 반복횟수 : i는 0번지부터 배열의 크기보다 작을 때까지 1씩 증가
		 * 규칙성 : 배열 i번지에 있는 값과 입력받는 값이 같으면 break로 반복문을 종료
		 * 반복문 종료 후 : i가 배열의 크기보다 작으면 ~은 있습니다. 라고 출력하고 같으면 ~은 없습니다 라고 출력
		 * */
		
		int i;
		for(i=0; i<arr.length; i++) {
			if(num == arr[i]) {
				break;
			}
		}
		
		// i=0 -> length(3)보다 작음 -> if 거짓 -> i 증가(1)
		// i=1 -> length(3)보다 작음 -> if 거짓 -> i 증가(2)
		// i=2 -> length(3)보다 작음 -> if 거짓 -> i 증가(3)
		// i=3 -> length(3)보다 작지 않음 -> 반복문 종료
		// 결과적으로 i=3
		
		
		if(i<arr.length) {
			System.out.println("방법1 : " + num + "은(는) 있습니다.");
		}
		else {
			System.out.println("방법1 : " +num + "은(는) 없습니다.");
		}
		
		/* 방법2
		 * 반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 * 규칙성 : 배열의 값과 입력받은 값이 같으면 boolean result를 true로 변경하고, 반복문을 종료
		 * 반복문 종료 후 : result가 true이면 ~은 있습니다. 라고 출력하고 아니면 ~은 없습니다 라고 출력
		 * */
		
		boolean result = false;
		for(int tmp : arr) {
				if(tmp == num) {
					result = true;
					break;
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
