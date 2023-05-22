package com.tech.blog.dao;
import java.sql.*;

import org.springframework.stereotype.Component;

import com.tech.blog.entities.User;




public class UserDao {
	
	private Connection con;
	
	public UserDao(Connection con) {
		this.con=con;
		
	}
	
	
	
	
	//get user by email and password
	public User getUserByEmailAndPassword(String email,String password) {
		
		User user=null;
		
		try {
			String useremail = email;
			String userpassword =password;

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM techblog WHERE email = ? AND password = ?");
			pstmt.setString(1, useremail);
			pstmt.setString(2, userpassword);

			ResultSet rs = pstmt.executeQuery();
			
			
			
			if(rs.next()) {
				user=new User();
				
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
			    user.setAbout(rs.getString("about"));
			    user.setDate(rs.getTimestamp("regdate"));
				user.setProfile(rs.getString("profile"));
				user.setId(rs.getInt("id"));
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
