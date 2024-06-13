package day12;

public class MathEx02 {

	public static void main(String[] args) {
		/* ceil 이용
		 * 3.14를 소수점 2번째 자리에서 올림하는 코드를 작성하세요. 
		 * 3.14를 31.4로 만들고 올림. 32를 3.2로 만들면*/
		
		double num = 3.14;
		double num2 = Math.ceil(num*10)/10;
		
		System.out.println(num + "를 소수점 2번째 자리에서 올림 : " + num2);
		
	}

}
