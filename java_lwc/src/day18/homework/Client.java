package day18.homework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client implements Serializable {
	
	private static final long serialVersionUID = -6554336258454504077L;
	
	private String ID;
	private String name;
	

}
