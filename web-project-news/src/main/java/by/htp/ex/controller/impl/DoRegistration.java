package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.dao.DaoException;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {
	
	private static final String NEW_LOGIN_PARAM = "login";
	private static final String NEW_PASSWORD_PARAM = "password";
	private static final String NEW_REGISTRATION_DATE_PARAM = "registration_date";
	private static final String NEW_EMAIL_PARAM = "email";
	private static final String NEW_TEL_PARAM = "tel";	
	
	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DaoException {
				
		String login;
		String password;
		String registration_date;
		String email;
		String tel;
				
		login = request.getParameter(NEW_LOGIN_PARAM);
		password = request.getParameter(NEW_PASSWORD_PARAM);
		registration_date = request.getParameter(NEW_REGISTRATION_DATE_PARAM);
		email = request.getParameter(NEW_EMAIL_PARAM);
		tel = request.getParameter(NEW_TEL_PARAM);
		
		NewUserInfo user = new NewUserInfo(login, password, registration_date, email, tel);
		
		try {
			String role = service.registration(user);

			if (!role.equals("guest")) {
				request.getSession(true).setAttribute("user", "active");
				request.getSession(true).setAttribute("role", role);
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				request.getSession(true).setAttribute("user", "not active");
				request.getSession(true).setAttribute("AuthenticationError", "wrong login or password");
				response.sendRedirect("controller?command=go_to_base_page");
			}
			
		} catch (ServiceException e) {
			// logging e
			// go-to error page
		}		
	}
}
