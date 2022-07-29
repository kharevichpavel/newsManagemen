package by.htp.ex.dao.impl;

import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.model.IUserSQL;
import by.htp.ex.model.SQLProvider;
import by.htp.ex.model.UserSQLException;

public class UserDAO implements IUserDAO{
	
	private final IUserSQL userSQL = SQLProvider.getInstance().getUserSQL();	

	@Override
	public boolean logination(String login, String password) throws DaoException, UserSQLException {
		if(userSQL.UserSql(login, password)) {
			return true;
		}		
		return false;		
	}
	
	public String getRole(String login, String password) throws DaoException, UserSQLException {
		if(logination(login, password)) {
			return "user";
		}
		return "guest";
	}

	@Override
	public boolean registration(String login, String password, String email, String tel) throws DaoException  {
		if(userSQL.UserSqlRegistration(login, password, email, tel)) {
			return true;
		}
		return false;
	}
	
	public String getRole(String login, String password, String email, String tel) throws DaoException, UserSQLException {
		if(registration(login, password, email, tel)) {
			return "user";
		}
		return "guest";
	}
}
