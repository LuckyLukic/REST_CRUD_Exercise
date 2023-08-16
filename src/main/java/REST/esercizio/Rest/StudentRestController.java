package REST.esercizio.Rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	//define endpoint to see the whole Student list
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return theStudents;
	}
	
	//define endpoint to return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//Check the student id
		
		if ( (studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFindException("student id not found " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	//Add exception handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFindException exc) {
		
		//Create a StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Add generic exception handler
	
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			//Create a StudentErrorResponse
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	
}
