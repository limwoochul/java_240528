package day02;

public class SelfQ01 {

	public static void main(String[] args) {
		//if-else if문
		int num1 = 10;
		int num2 = 2;
		char operator = '+';
		int res1 = 0;		
		
		if(operator == '+') {
			res1 = num1 + num2;
		}
		else if(operator == '-') {
			res1 = num1 - num2;
		}
		else if(operator == '*') {
			res1 = num1 * num2;
		}
		else if(operator == '/') {
			res1 = num1 / num2;
		}
		else {
			System.out.println("잘못된 입력입니다.");
		}
		System.out.println("else if문 결과");
		System.out.println("" + num1 + " " + operator + " " + num2 + " = " + res1);
		System.out.println("");
		
		int num3 = 10;
		int num4 = 2;
		int res2 = 0;
		
		switch(operator) {
		case '+' : res2 = num3 + num4;
				break;
		case '-' : res2 = num3 - num4;
				break;
		case '*' : res2 = num3 * num4;
				break;
		case '/' : res2 = num3 / num4;
				break;
		default : System.out.println("잘못된 입력입니다.");
		}
		System.out.println("switch case문 결과");
		System.out.println("" + num3 + " " + operator + " " + num4 + " = " + res2);
		
		
	}

}
