package account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(date, other.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	

	
	
}
