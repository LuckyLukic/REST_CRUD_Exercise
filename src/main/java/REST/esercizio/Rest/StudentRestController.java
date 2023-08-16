package REST.esercizio.Rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Student;
import jakarta.annotation.PostConstruct;



@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//@PostConstruct to load the student data only once
	@PostConstruct
	public void loadData() {
		
        theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Luca", "Iannice"));
		theStudents.add(new Student("Ari", "Ki"));
		theStudents.add(new Student("Ciccio", "Cicciooo"));
		
	}

	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		
		
		return theStudents;
	}
}
