package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Util.UserUtil;
import com.bean.User;

public class UserDao {

	public static void insertUser(User u)
	{
		try {
			Connection conn=UserUtil.createConnection();
            String sql="insert into user(fname,lname,email,mobile,dob,gender,pas) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, u.getFname());
            pst.setString(2, u.getLname());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getMobile());
            pst.setString(5, u.getDob());
            pst.setString(6, u.getGender());
            pst.setString(7, u.getPas());
            pst.executeUpdate();
		} catch (Exception e) {
            e.printStackTrace();
		}
				
	}
	public static List<User> getAllUser()
	{
		List<User> list=new ArrayList<User>();
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from user";
			PreparedStatement pst=conn.prepareStatement(sql);
		    ResultSet rs=pst.executeQuery();
		    while(rs.next())
		    {
		       User u=new User();
		       u.setU_id(rs.getInt("u_id"));
		       u.setFname(rs.getString("fname"));
		       u.setLname(rs.getString("lname"));
		       u.setEmail(rs.getString("email"));
		       u.setMobile(rs.getString("mobile"));
		       u.setDob(rs.getString("dob"));
		       u.setGender(rs.getString("gender"));
		       u.setPas(rs.getString("pas"));
		       list.add(u);
		    }
		} catch (Exception e) {
           e.printStackTrace();
		}
		return list;
	}
	
	public static void deleteUser(int u_id)
	{
		try {
		Connection conn=UserUtil.createConnection();
		String sql="delete from user where u_id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, u_id);
		pst.executeUpdate();
		}
		catch (Exception e) {
               e.printStackTrace();
		}
	}
		
}
