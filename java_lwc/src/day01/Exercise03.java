package day01;

public class Exercise03 {

	public static void main(String[] args) {

		int num1 = 10;
		int i = 2;
		
		boolean value = ((num1 = num1 + 10) < 10) && ((i = i + 2) < 10);//true, false
		System.out.println(value); //false
		System.out.println(num1); //num1 = 20
		System.out.println(i); //i = 2
		
		value = ((num1 = num1 + 10) > 10) || ((i = i + 2) < 10);//true, true
		System.out.println(value); //true
		System.out.println(num1); //num1 = 30
		System.out.println(i); //i = 2
	}

}
