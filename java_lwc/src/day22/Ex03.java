package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		/* 리스트에 숫자들을 저장하고 저장된 숫자들을 정렬하는 코드를 작성하세요.
		 * */
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(1);
		list.add(40);
		list.add(23);
		list.add(15);
		
		System.out.println("리스트 : " + list);
		
		Collections.sort(list);
		
		System.out.println("오름차순 : " +list);

		//Collections.reverse(list); //요소들을 역순으로 배치 -> 역순으로 정렬이 X 뒤집어주기만 함
		/*
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		*/
		
		Collections.sort(list, (i1,i2)-> i2-i1); // 람다식 이용
		
		System.out.println("내림차순 : " + list);
	}

}
