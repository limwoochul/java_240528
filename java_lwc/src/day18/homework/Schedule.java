package day18.homework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientID;
	private String date;
	private String detail;
	private String status;
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Schedule(String clientID, String date, String detail, String status) {
		this.clientID = clientID;
		this.date = date;
		this.detail = detail;
		this.status = status;
	}
	@Override
	public String toString() {
		return date + " / " + detail + " / " + status;
	}
	
}
