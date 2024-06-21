package day18.homework;

import java.io.Serializable;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = -4864747137826310891L;

	private String date;
	private String schedule;
	private String condition;
	
	@Override
	public String toString() {
		return date + " / " + schedule + " / " + condition;
	}
	

}
