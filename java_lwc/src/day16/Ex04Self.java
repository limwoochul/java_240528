package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex04Self {

	public static void main(String[] args) {
		List<Student2> list = new ArrayList<Student2>();
		list.add(new Student2(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new Student2(1, 1, 2, "고길동", 100, 100, 100));
		list.add(new Student2(1, 2, 1, "둘리", 60, 60, 70));
		
		/* 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
		/* 각 학생의 국어, 영어 수학 성적을 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
		int korSum = 0, engSum = 0, mathSum = 0;
		double korAvg, engAvg, mathAvg;
		
		for(int i=0; i<list.size(); i++) {
			korSum += list.get(i).getKor();
			engSum += list.get(i).getEng();
			mathSum += list.get(i).getMath();
		}
		
		korAvg = korSum / (double)list.size();
		engAvg = engSum / (double)list.size();
		mathAvg = mathSum / (double)list.size();
		System.out.println("=====과목별 평균======");
		System.out.println("세 학생의 국어 평균 : " + korAvg);
		System.out.println("세 학생의 영어 평균 : " + engAvg);
		System.out.println("세 학생의 수학 평균 : " + mathAvg);
		System.out.println();
		
		
		System.out.println("=====각 학생의 성적=====");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println();
		print(list, c -> System.out.println(c));
		
	}
	
	public static void print(List<Student2> list, Consumer<Student2> c) {
		for(Student2 tmp : list) {
			c.accept(tmp);
		}
	}

}

@Data
@AllArgsConstructor

class Student2{
	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;
	
	@Override
	public String toString() {
		return "[" +name + "학생의 성적] 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math;
	}
}