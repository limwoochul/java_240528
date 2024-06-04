package day06;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		//4자리 정수를 입력받아 입력받은 정수를 역순으로 배열에 저장하고, 출력하는 코드를 작성
		//1234 => 0번지에 4, 1번지에 3, 2번지에 2, 3번지에 1을 저장하고 , 4,3,2,1 순으로 출력
		
		//4자리 정수 입력
		
		//4자리 정수가 아니면 잘못입력했다고 출력
		
		//4자리 정수이면
			//역순으로 배열에 저장, %연산과 /연산을 이용
			//1234 => 4를 추출해서 배열에 저장하고, 1234 => 123으로 만듦
			//123 => 3을 추출해서 배열에 저장하고, 123 => 12로 만듦
			//12 => 2를 추출해서 배열에 저장하고, 12=>1로 만듦
			//1 => 1을 추출해서 배열에 저장하고, 1=>0으로 만듦
		
		//배열에 값을 순차적으로 출력
		
		Scanner scan = new Scanner(System.in);
		int num=0;
		do {
			System.out.print("4자리 정수 입력 : ");
			num = scan.nextInt();
			if(num>=1000 && num < 10000) {
				break;
			}
			else {
			System.out.println("잘못된 입력입니다.");
			}
		}while(num<1000 || num>=10000);
		
		
		int [] arr = new int[4];
		for(int i=0; i<arr.length; i++) {
			arr[i] = num % 10;
			num /= 10;
		}
		
		System.out.print("입력받은 값을 역순으로 출력 : ");
		for(int tmp : arr) {
			System.out.print(tmp);
		}
		

	}

}
