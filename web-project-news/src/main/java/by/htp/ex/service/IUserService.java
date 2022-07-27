package by.htp.ex.service;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.model.UserSQLException;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException, UserSQLException;
	boolean registration(NewUserInfo user) throws ServiceException;

}
