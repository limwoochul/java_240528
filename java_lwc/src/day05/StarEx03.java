package day05;

public class StarEx03 {

	public static void main(String[] args) {
		/* *을 하나씩 출력해서 다음과 같이 출력되도록 중첩 반복문을 이용하여 작성하세요.
		 *     *	i=1,	공백=4,	*=1
		 *    **	i=2,	공백=3,	*=2
		 *   ***	i=3,	공백=2,	*=3
		 *  ****	i=4,	공백=1,	*=4
		 * *****	i=5,	공백=0,	*=5
		 * 					공백=5-i,	*=i 개
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : *을 i개 출력 후 엔터
		 * 		=>	반복횟수 : j는 1부터 ?까지 1씩 증가
		 * 			규칙성 : 공백을 출력
		 * 			반복문 종료 후 : 없음
		 * 		=>	반복횟수 : j는 1부터 i까지 1씩 증가
		 * 			규칙성 : *을 출력
		 * 			반복문 종료 후 : 엔터 출력
		 * 반복문 종료 후 : 없음
		 * */
		

		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
