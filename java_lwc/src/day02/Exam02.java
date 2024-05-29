package day02;

public class Exam02 {

	public static void main(String[] args) {

		int num1 = 1, num2 = 2;
		char ch = '+';
		//num1, num2, ch를 이용하여 1+2가 출력되도록 콘솔에 코드를 작성해보세요.
		String str = "" + num1 + ch + num2;
		System.out.println("" + num1 + ch + num2);
		System.out.println(str); //정수 + 문자열 + 정수 -> 문자열이 유니코드 정수값으로 바뀜
								//"" + 정수 + 문자열 + 정수
								// 앞쪽에 빈 문자열을 넣어줘서 문자열 + 정수 = 문자열로 바꾸면
								//(문자열) + 문자열 + 정수 의 형태로 바뀜
	}

}
