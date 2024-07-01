package day24;

public class Ex01 {

	public static void main(String[] args) {
		int num1 = 4;
		double num2 = num1;
		
		//num2=num1에서 num2는 실수형, num1은 정수형이기때문에 묵시적형변환이 자동으로 되고
		//num3=num2에서 실수형이 정수형으로 형변환이 되기 때문에 강제적으로 형변환시켜준다
		//int num3 = (int)num2;
		
		/* 에러 발생
		 * 원인 : 실수를 정수로 자동 자료형변환 하려고 했기 때문에
		 * 해결방법 : 명시적 형변환을 하던지 실수형 변수에 저장
		 * */
		
		//int num3 = num2;

	}

}
