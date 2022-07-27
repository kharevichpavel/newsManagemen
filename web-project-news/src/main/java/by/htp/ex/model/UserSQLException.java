package by.htp.ex.model;

public class UserSQLException extends Exception{
	
	private static final long serialVersionUID = 126482015468603723L;
	
	
	public UserSQLException() {
		super();
	}
	
	public UserSQLException(String message) {
		super(message);
	}
	
	public UserSQLException(Exception e) {
		super(e);
	}
	
	public UserSQLException(String message, Exception e) {
		super(message, e);
	}

}
