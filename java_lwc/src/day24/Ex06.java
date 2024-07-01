package day24;

public class Ex06 {

	public static void main(String[] args) {
		
		/* 1부터 10까지 출력하는 코드를 작성하려고 했다.
		 * 원인 : 증감식이 없기 때문에 무한루프에 빠져 0이 계속 출력된다. 또한 1부터 10까지인데 초기화를 0으로 시작했다.
		 * 해결방법 : 증감식 i++ 혹은 i+=1을 추가 / 초기화 i=1로 변경
		 * */
		for(int i=0; i<=10; ) {
			System.out.println(i);
		}

	}

}
