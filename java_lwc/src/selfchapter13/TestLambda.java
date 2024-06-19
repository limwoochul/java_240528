package selfchapter13;

public class TestLambda {

	public static void main(String[] args) {
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("hello lamda_1");
		showMyString(lambdaStr);
	}


	public static void showMyString(PrintString p) {
		p.showString("hello lamda_2");
	}
}
interface PrintString{
	void showString(String str);
}