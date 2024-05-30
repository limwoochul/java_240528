package day03;

import java.util.Calendar;
import java.util.Date;

public class SelfEx08 {

	public static void main(String[] args) {
		
		SelfEx07 date1 = new SelfEx07(30, 2, 2000);
		System.out.println(date1.isValid());
		SelfEx07 date2 = new SelfEx07(2, 10, 2006);
		System.out.println(date2.isValid());
		
	}

}
