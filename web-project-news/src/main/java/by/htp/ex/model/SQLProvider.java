package by.htp.ex.model;

public class SQLProvider {

	private static final SQLProvider instance = new SQLProvider();

	private final IUserSQL userSQL = new UserSQL();
		
	private SQLProvider() {
	}	
	
	public IUserSQL getUserSQL() {
		return userSQL;
	}	
	
	public static SQLProvider getInstance() {
		return instance;
	}
}
