package day08;

import java.util.Arrays;

public class MethodEx03 {

	public static void main(String[] args) {
		int a = 1, b = 2;
		int num1 = 1, num2 = 2;
		
		System.out.println(sum(a,b));
		System.out.println(sum(1,2));
		System.out.println(sum(num1,num2));
		
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		swap(num1,num2);
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		

		
		int[] arr = new int[] {1,2,3};
		
		
		Arrays.sort(arr);
		
	}
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	/* 매개변수의 값이 메서드 안에서 바뀌어도 메서드를 호출한 곳에서는 안 바뀜*/
	public static void swap(int num1, int num2) {
		int tmep = num1;
		num1 = num2;
		num2 = num1;
		
	}
	
	/* 매개변수는 꼭 필요한 정보만, 아래 코드는 기껏 넘겨준 num2를 메서드에서 재할당하여 사용해서 밖에서
	 * 념겨준 값이 의미가 없어짐. 이럴 땐 매개변수에서 제거하고 지역변수로*/
	
	public static void test(int num1, int num2) {
		num2 = 10;
		System.out.println(num1+num2);
	}
	public static void test1(int num1) {
		int num2 = 10;
		System.out.println(num1+num2);
	}
	

}
