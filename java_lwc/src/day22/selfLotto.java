package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class selfLotto {


	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		int min=1, max=45;
		
		int count = 0;
		
		int num = 0;
		
		for(int i=0; i<5; i++) {
			while(count<6) {
				num = (int)(Math.random()*(max-min+1)+min);
				if(list.contains(num)) continue;
				list.add(num);
				count++;
			}
			
			Collections.sort(list);
			System.out.println(list);
			
			count = 0;
			list.clear();
		}
		
	}

}
