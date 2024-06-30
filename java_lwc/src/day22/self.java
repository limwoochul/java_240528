package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class self {


	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		int min=1, max=45;
		
		for(int i=0; i<6; i++) {
			list.add((int)(Math.random()*(max-min+1)+min));
		}
		
		Collections.sort(list);
		
		System.out.println(list);
	}

}
