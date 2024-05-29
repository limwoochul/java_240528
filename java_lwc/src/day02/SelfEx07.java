package day02;

public class SelfEx07 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		int sum = add(num1,num2);
		System.out.println(num1 + " + " + num2 + " = " + sum + "입니다.");
		int res1 = minus(num1,num2);
		System.out.println(num1 + " - " + num2 + " = " + res1 + "입니다.");
		int res2 = multi(num1,num2);
		System.out.println(num1 + " * " + num2 + " = " + res2 + "입니다.");
		int res3 = devide(num1,num2);
		System.out.println(num1 + " / " + num2 + " = " + res3 + "입니다.");
		
	}
	
	public static int add(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	
	public static int minus(int n1, int n2) {
		int result = n1 - n2;
		return result;
	}
	
	public static int multi(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	
	public static int devide(int n1, int n2) {
		int result = n1 / n2;
		return result;
	}
	
	

}
