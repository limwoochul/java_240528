package project1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phoneNumber;
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
