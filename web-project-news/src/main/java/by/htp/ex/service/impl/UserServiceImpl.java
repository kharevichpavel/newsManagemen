package by.htp.ex.service.impl;

import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.model.UserSQLException;
import by.htp.ex.service.ServiceException;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService{

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataValidation();
	
	@Override
	public String signIn(String login, String password) throws ServiceException, UserSQLException {
		
		/*
		 * if(!userDataValidation.checkAUthData(login, password)) { throw new
		 * ServiceException("login ...... "); }
		 */
		
		try {
			if(userDAO.logination(login, password)) {
				return userDAO.getRole(login, password);
			}else {
				return "guest";
			}			
		}catch(DaoException e) {
			throw new ServiceException(e);
		}		
	}

	@Override
	public String registration(String login, String password, String email, String tel) throws DaoException, UserSQLException {
		if(userDAO.registration(login, password, email, tel)) {
			return "user";
		}
		return "guest";
	}
}
