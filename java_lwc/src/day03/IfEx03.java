package day03;

public class IfEx03 {

	public static void main(String[] args) {
		//else if 예제
		int num = 3;
		//num가 0이면 0이라고 출력
		//num가 0이 아니고 양수이면 양수라고 출력하고
		//num가 0과 양수가 아니면 음수라고 출력하는 코드를 작성하세요.
		
		if(num == 0) {
			System.out.println(0);
		}
		else if(num > 0) {
			System.out.println(num + "은 양수입니다.");
		}
		else {
			System.out.println(num + "은 음수입니다.");
		}
		
		
		
	}

}
