package day18.homework.v1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Schedule implements Comparable<Schedule>, Serializable {
	private static final long serialVersionUID = 1L;
	private String date;//날짜
	private String toDo;//할일
	private String detail;//상세
	
	@Override
	public String toString() {
		return "" + date + " " + toDo + " : " + detail + "";
	}
	
	/* @AllArgsContructor를 안 쓰고 추가한 이유는 날짜 문자열을 Date 객체 문자열로 바꾸는
	 * 작업을 setDate()를 이용하기 위해서
	 * */
	public Schedule(String date, String toDo, String detail) {
		this.date = date;
		this.toDo = toDo;
		this.detail = detail;
	}
	
	@Override
	public int compareTo(Schedule o) {
		return date.compareTo(o.date);
	}
	
	
}
