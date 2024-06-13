package selfchapter10;

public class CompleteCalc extends Calculator {

	public int times(int num1, int num2) {
		return num1 * num2;
	}

	public int divide(int num1, int num2) {
		if(num2 != 0) {
			return num1 / num2;
		}
		else {
			return Calc.ERROR;
		}
	}
	
	public int square(int num) {
		return num * num;
	}
	
	@Override
	public void description() {
		// TODO Auto-generated method stub
		super.description();
	}

	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현하셨습니다.");
	}


}
