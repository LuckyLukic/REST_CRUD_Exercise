package REST.esercizio.Rest;

@SuppressWarnings("serial")
public class StudentNotFindException extends RuntimeException{

	public StudentNotFindException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFindException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFindException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
