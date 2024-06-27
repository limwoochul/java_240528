package day22;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 정수로 이루어진 문자열에서 각 정수들의 합을 구하는 코드를 작성하세요.
		 * 예시
		 * 1 23 45 3 9 7 5
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수로 이루어진 문자열 입력 : ");
		String numbers = scan.nextLine();
		
		int sum = sumByString(numbers);
				
		System.out.println("정수들의 합 : " + sum);

	}
	
	/* 위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때 필요하다고 생각하는 코드를
	 * 메소드로 만들어 보세요.*/

	
	/**주어진 문자열에 있는 정수들을 더해서 더한 결과를 반환하는 메소드
	 * @param str 정수들이 있는 문자열
	 * @return 문자열에 있는 정수들의 합
	 * */
	public static int sumByString(String numbers) {

		String [] numArr = numbers.split(" ");
		int sum = 0;
		for(int i=0; i<numArr.length; i++) {
			sum += Integer.parseInt(numArr[i]);
		}
		
		return sum;
	}

}
