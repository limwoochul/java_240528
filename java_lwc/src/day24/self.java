package day24;

import java.util.regex.Pattern;

public class self {

	public static void main(String[] args) {
	
		String regex1 = "^\\w{4,15}$";
		String str1 = "abc123";
		
		System.out.println(Pattern.matches(regex1, str1));
	}

}
