package by.htp.ex.dao.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.model.IUserSQL;
import by.htp.ex.model.SQLProvider;

public class UserDAO implements IUserDAO{
	
	private final IUserSQL userSQL = SQLProvider.getInstance().getUserSQL();
	

	@Override
	public boolean logination(String login, String password) throws DaoException, ClassNotFoundException {			
		
		if(userSQL.UserSql(login, password)) {
			return true;
		}		
		return false;		
	}
	
	public String getRole(String login, String password) {
		return "user";
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException  {
		// TODO Auto-generated method stub
		return true;
	}

}
