package by.htp.ex.service;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException;
	String registration(NewUserInfo user) throws ServiceException, DaoException;	
}
