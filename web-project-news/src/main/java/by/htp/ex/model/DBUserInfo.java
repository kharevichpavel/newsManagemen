package by.htp.ex.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.htp.ex.bean.UserInfo;

public class DBUserInfo {
	 private static String URL = "jdbc:mysql://127.0.0.1/newsmanagement?useSSL=false&useUnicode=true&serverTimezone=UTC";
	 private static String ROOT = "root";
	 private static String PASSWORD = "813150";
	 
	 private Connection con = null;
	 private Statement st = null;
	 private ResultSet resultSet = null;
	    
	 public ArrayList<UserInfo> select() {
	         
	 ArrayList<UserInfo> userDB = new ArrayList<UserInfo>();
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	        
	        con = DriverManager.getConnection(URL, ROOT, PASSWORD);      
	        st = con.createStatement();
	        resultSet = st.executeQuery("SELECT * FROM users");
	        while(resultSet.next()){
	                      
	            String loginUser = resultSet.getString(2);
	            String passwordUser = resultSet.getString(3);	                    
	            UserInfo userInfo = new UserInfo(loginUser, passwordUser);
	            userDB.add(userInfo);	                    
	        }
	        
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userDB;	    
	}
	 
	    public int insert(String login, String password, String email, String tel) {
	    	 
	    	try{    		
	    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	    		con = DriverManager.getConnection(URL, ROOT, PASSWORD);       
	    		String sql = "INSERT INTO users (loginUser, passwordUser, emailUser, telUser) Values (?, ?, ?, ?)";
	    		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
	    			preparedStatement.setString(1, login);
	    			preparedStatement.setString(2, password);
	    			preparedStatement.setString(3, email);
	    			preparedStatement.setString(4, tel);
           
	    			return  preparedStatement.executeUpdate();
	    		}	    		
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}finally {
	            try {
	                if (resultSet != null) {
	                    resultSet.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            try {
	                if (st != null) {
	                    st.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            try {
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    	return 0;
	    }
	}



/*	    public static DBUserInfo selectOne(int id) {

Product product = null;
try{
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    try (Connection conn = DriverManager.getConnection(url, username, password)){
          
        String sql = "SELECT * FROM products WHERE id=?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

                int prodId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                product = new Product(prodId, name, price);
            }
        }
    }
}
catch(Exception ex){
    System.out.println(ex);
}
return product;
}*/


/*	    public static int update(Product product) {
 
try{
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    try (Connection conn = DriverManager.getConnection(url, username, password)){
          
        String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());
              
            return  preparedStatement.executeUpdate();
        }
    }
}
catch(Exception ex){
    System.out.println(ex);
}
return 0;
}*/
/*	    public static int delete(int id) {
 
try{
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    try (Connection conn = DriverManager.getConnection(url, username, password)){
          
        String sql = "DELETE FROM products WHERE id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
              
            return  preparedStatement.executeUpdate();
        }
    }
}
catch(Exception ex){
    System.out.println(ex);
}
return 0;
}*/

