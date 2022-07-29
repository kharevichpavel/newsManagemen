package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.model.UserSQLException;

public interface IUserDAO {
	
	boolean logination(String login, String password) throws DaoException, UserSQLException;
	boolean registration(String login, String password, String email, String tel) throws DaoException;
	public String getRole(String login, String password) throws DaoException, UserSQLException;
	public String getRole(String login, String password, String email, String tel) throws DaoException, UserSQLException;
	
}
