package by.htp.ex.model;

import java.util.ArrayList;
import by.htp.ex.bean.DBUserInfo;
import by.htp.ex.bean.UserInfo;

public class UserSQL implements IUserSQL{
	
	DBUserInfo dbUserInfo = new DBUserInfo();	

	@Override
	public boolean UserSql(String login, String password) throws UserSQLException {
						
		ArrayList<UserInfo> log = dbUserInfo.select();
		
		String res = login.concat(password);		
		
		int number = 0;		
		for(UserInfo i:log) {			
			if(res.equals(i.toString())) {
				number=1;
			}			
		}
		if(number==1) {
			return true;
		}		
		return false;
	}
}
