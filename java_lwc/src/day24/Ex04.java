package day24;

public class Ex04 {

	public static void main(String[] args) {
		int score = 80;
		
		/* A를 판별하는 코드를 작성했는데, A가 아닌 경우에도 A가 출력
		 * 원인 : score가 80일때 90이상이다->false, 100이하이다->true 이기 때문에 둘 중 하나가 true여서 출력됨
		 * 해결방안 : || or을 쓰지 않고 && and연산자를 써야함
		 * */
		
		if(score >= 90 || score <= 100) {
			System.out.println("A");
		}

	}

}
