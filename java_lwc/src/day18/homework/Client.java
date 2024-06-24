package day18.homework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Client implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
	
	

}
