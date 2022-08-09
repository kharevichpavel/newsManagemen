package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.UserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.connectionpool.ConnectionPool;
import by.htp.ex.dao.connectionpool.ConnectionPoolException;


public class UserDAO implements IUserDAO{
	
	private final String selectForLogination = "SELECT * FROM users";	
	
	@Override
	public boolean logination(String login, String password) throws DaoException{
		
		try(Connection connection = ConnectionPool.getInstance().takeConnection();
			Statement st = connection.createStatement();){			
			ResultSet rs = st.executeQuery(selectForLogination);						
	        while(rs.next()){	        	
	            String loginUser = rs.getString(2);
	            String passwordUser = rs.getString(3);
	            UserInfo userInfo = new UserInfo(loginUser, passwordUser);
	            if(userInfo.getLogin()==null | userInfo.getPassword()==null) {
	            	return false;
	            }
	            if(userInfo.getLogin().equals(login) & userInfo.getPassword().equals(password)) {
	            	return true;
	            }	           
	        }
			return false;	        
		}catch (SQLException e) {
			throw new DaoException(e);
		}catch (ConnectionPoolException e) {
			throw new DaoException(e);
		}				
	}	
	
	String insertNewUserInUsers = "INSERT INTO users (login,password,registration_date,email,tel,roles_id) values (?,?,?,?,?,?)";	
	
	@Override
	public boolean registration(NewUserInfo user) throws DaoException {		
		
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        PreparedStatement ps = connection.prepareStatement(insertNewUserInUsers)){	
			Statement st = connection.createStatement();			
			ResultSet rs = st.executeQuery(selectForLogination);						
		        while(rs.next()){	        	
		            String loginUser = rs.getString(2);
		            String email = rs.getString(5);
		            String tel = rs.getString(6);
		            if (loginUser.equals(user.getLogin()) || email.equals(user.getEmail()) || tel.equals(user.getTel())) {
		            	return false;
		            }
		        }			
	        ps.setString(1, user.getLogin());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, getDate());
	        ps.setString(4, user.getEmail());	
	        ps.setString(5, user.getTel());
	        ps.setInt(6, 2);
	        ps.executeUpdate();
	        return true;
	    } catch (SQLException e) {
	    	//System.out.println(e.getMessage());	        
	    } catch (ConnectionPoolException e) {
	        throw new DaoException(e);
	    }
		return false; 	        
	}

	private String getDate() {
	    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("GMT+3"));
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	    String date = dateTimeFormatter.format(zonedDateTime);	    
	    return date;
	}
	
	String selectUserRole = "SELECT roles.title FROM users INNER JOIN roles ON users.roles_id=roles.id WHERE users.login=? AND users.password=?";
	
	public String getRole(String login, String password) throws DaoException{
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
			PreparedStatement ps = connection.prepareStatement(selectUserRole)) {
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) {
				return rs.getString("title");
			}			
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ConnectionPoolException e) {
			throw new DaoException(e);
		}
		return "guest";
	}
	
	public String getRole(NewUserInfo user) throws DaoException {		
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(selectUserRole)) {
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				ResultSet rs = ps.executeQuery(); 
				if (rs.next()) {
					return rs.getString("title");
				}			
			} catch (SQLException e) {
				throw new DaoException(e);
			} catch (ConnectionPoolException e) {
				throw new DaoException(e);
			}
		return "guest";
	}
}
