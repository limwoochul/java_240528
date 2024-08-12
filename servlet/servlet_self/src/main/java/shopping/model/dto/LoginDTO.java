package shopping.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private int question;
	private String answer;
}
