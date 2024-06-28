package account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account implements Comparable<Account>, Serializable {

	private static final long serialVersionUID = 123L;
	private String date;
	private String bigCategory;
	private String smallCategory;
	private String detail;
	private int money;
	
	@Override
	public String toString() {
		return date + " | " + bigCategory + " | " + smallCategory
				+ " | " + money + " | " + detail;
	}

	@Override
	public int compareTo(Account o) {
		return date.compareTo(o.date);
	}

	

	
	
}
