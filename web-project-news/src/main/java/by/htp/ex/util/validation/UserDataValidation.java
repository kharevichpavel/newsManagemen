package by.htp.ex.util.validation;

import org.apache.catalina.User;

public interface UserDataValidation {
       boolean checkAUthData(String login, String password);
       boolean checkRegistrationData(User user);
}
