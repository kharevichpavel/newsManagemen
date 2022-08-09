package by.htp.ex.util.validation;

import java.util.regex.Pattern;
import by.htp.ex.bean.NewUserInfo;

public class UserDataValidationImpl implements UserDataValidation{

	@Override
	public boolean checkAUthData(String login, String password) {
		if(login.isEmpty() || password.isEmpty()){
            return false;
        }
        if (Pattern.matches("[a-zA-Z0-9_]+", login)
                && Pattern.matches("[a-zA-Z0-9_]+", password)) {
            return true;
        }
		return false;
	}

	@Override
	public boolean checkRegistrationData(NewUserInfo user) {
		String login=user.getLogin();
        String password=user.getPassword();        
        String email=user.getEmail();
        String tel=user.getTel();
        if(login.isEmpty() || password.isEmpty() || email.isEmpty() || tel.isEmpty()){
            return false;
        }
        if (Pattern.matches("[a-zA-Z0-9_]+", login)
                && Pattern.matches("[a-zA-Z0-9_]+", password)
                && Pattern.matches("[a-zA-Z0-9_]+@[a-z]+.([a-z]+[^0-9])", email)
                && Pattern.matches("[+]{1}([0-9]){12}", tel)) {
            return true;
        }
		return false;
	}
}
