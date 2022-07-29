package by.htp.ex.service;

import by.htp.ex.dao.DaoException;
import by.htp.ex.model.UserSQLException;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException, UserSQLException;
	String registration(String login, String password, String email, String tel) throws ServiceException, DaoException;
	
}
