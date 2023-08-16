package REST.esercizio.Rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Student;



@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Luca", "Iannice"));
		theStudents.add(new Student("Ari", "Ki"));
		theStudents.add(new Student("Ciccio", "Cicciooo"));
		
		return theStudents;
	}
}
