package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
	
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName) {
	
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

}
