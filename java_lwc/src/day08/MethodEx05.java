package day08;

import java.util.Arrays;

public class MethodEx05 {

	public static void main(String[] args) {
		/* 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지 확인하는 코드를 작성하세요.
		 * 단, 메서드를 이용하여*/

		int[] arr = null;
		int num = 5;
				
		boolean result = result(arr, num);
		
		if(result) {
			System.out.println(num + "은 있습니다.");
		}
		else {
			System.out.println(num + "은 없습니다.");
		}
		
	}
	
	/**기능 : 배열 안에 정수가 있는지 없는지 확인하는 메서드
	 * 매개변수 : int[] list, int num
	 * 리턴타입 : boolean
	 * 메서드명 : result
	 * */
	
	public static boolean result(int[] list, int num) {
		//배열이 null이면 false를 리턴
		
		//반복문을 이용하여 배열 전체를 탐색
		
			//배열에서 꺼낸 값과 num가 같으면 true를 리턴
		
		//반복문이 끝날때까지 못찾으면 false를 리턴
		
		if(list == null) return false;
		
		for(int tmp : list) {
			if(tmp == num) return true;
		}
		
		return false;
	}

}
