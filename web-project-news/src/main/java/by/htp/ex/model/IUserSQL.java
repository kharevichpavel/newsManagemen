package by.htp.ex.model;

public interface IUserSQL {
	
	public boolean UserSql(String login, String password) throws UserSQLException;
	public boolean UserSqlRegistration(String login, String password, String email, String tel);

}
