package com.pets.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.pets.dto.AddressDTO;
import com.pets.dto.UserDTO;
import com.pets.service.UserService;
import com.pets.utls.JDBCUtils;

public class UserDAO
{
	/**
	 * 根据用户名获得用户对象
	 * @param username
	 * @return
	 */
	public static UserDTO getByUserEmail(String Email)
	{
		
		ResultSet rs = null;
		try
		{
			rs = JDBCUtils.executeQuery(
					"select * from T_Users where email=?", Email);
			if (rs.next())
			{
				return toModel(rs);
			} else
			{
				return null;
			}
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		} finally
		{
			JDBCUtils.closeAll(rs);
		}
	}

	public static UserDTO toModel(ResultSet rs) throws SQLException
	{
		UserDTO user = new UserDTO();
		user.setId(rs.getLong("Id"));
		user.setEmail(rs.getString("Email"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setScore(rs.getLong("score"));
		user.setMoney(rs.getFloat("money"));
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
		return user;
	}

	
	/**
	 * 检查账号密码是否正确
	 */
	public boolean checkLogin(String email,String password)
	{
		UserDTO userdto= new UserDTO();
	    UserService userService = new UserService();
	    userdto=userService.selectUserByEmail(email);
	    System.out.println(userdto.toString());
		if(userdto.getPassword().equals(password))
		{
			return true;
		}
	    
		return false;
		
		
	}
/**
 * 
 * @param user
 */
public void updateByUser(UserDTO user) {
		if(user==null)
		{
			throw new IllegalArgumentException("错误");
		}
        try {
			JDBCUtils.executeNonQuery("update t_users set password=? , name=? ,phone=? where email=?", user.getPassword(),user.getName(),user.getPhone(),user.getEmail());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
public long addnew(UserDTO user) {
		String email=user.getEmail();
		String password=user.getPassword();
		String name="会员";
		try {
			
     	return JDBCUtils.executeInsert("insert into T_Users(email,password,name,score) values(?,?,?,1000)",email, password,name);
	
		}
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}
/*
 * 
 */
/*
 * many to many
 * 
select p.* from t_users u left join t_shopcars s on u.id=s.userid 
left join t_pets p on s.petsid = p.id where u.id=1
 */

	public void push(Long userid) {
		try {
			
	     	 JDBCUtils.executeInsert("delete from t_shopcars where userid=?",userid);
		
			}
			catch (SQLException e) 
			{
				throw new RuntimeException(e);
			}
	}

	public UserDTO[] getAll() {
		
			StringBuilder sb = new StringBuilder();
			/*
			 * select a.* from t_users u left join t_addresses a on u.id=a.userid where userid = 1
			 */
			sb.append("select * from t_users");

			List<UserDTO> list = new ArrayList<>();
			ResultSet rs = null;
			try {
				rs = JDBCUtils.executeQuery(sb.toString());
				while (rs.next()) {
					list.add(toModel(rs));
				}
				return list.toArray(new UserDTO[list.size()]);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			} finally {
				JDBCUtils.closeAll(rs);
			}

		}

	public UserDTO selectUserByid(Long id) {
		ResultSet rs = null;
		try
		{
	     	rs=JDBCUtils.executeQuery("select * from t_users where id=?",id);

			if (rs.next())
			{
				return toModel(rs);
			} else
			{
				return null;
			}
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		} finally
		{
			JDBCUtils.closeAll(rs);
		}
	}

	
	
}
