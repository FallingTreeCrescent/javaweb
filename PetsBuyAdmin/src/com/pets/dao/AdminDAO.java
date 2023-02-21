package com.pets.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.pets.dto.AddressDTO;
import com.pets.dto.AdminDTO;
import com.pets.dto.AdminDTO;
import com.pets.service.AdminService;
import com.pets.utls.JDBCUtils;

public class AdminDAO
{
	/**
	 * 根据用户名获得用户对象
	 * @param adminname
	 * @return
	 */
	public static AdminDTO getByadminEmail(String Email)
	{
		
		ResultSet rs = null;
		try
		{
			rs = JDBCUtils.executeQuery(
					"select * from T_admins where email=? and isDeleted = false", Email);
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

	public static AdminDTO toModel(ResultSet rs) throws SQLException
	{
		AdminDTO admin = new AdminDTO();
		admin.setId(rs.getLong("Id"));
		admin.setEmail(rs.getString("Email"));
		admin.setPassword(rs.getString("password"));
		admin.setName(rs.getString("name"));
        admin.setPhone(rs.getString("phone"));
        admin.setIsDeleted(rs.getBoolean("isDeleted"));
        
        
		return admin;
	}

	
	/**
	 * 检查账号密码是否正确
	 */
	public boolean checkLogin(String email,String password)
	{
		AdminDTO AdminDTO= new AdminDTO();
	    AdminService AdminService = new AdminService();
	    AdminDTO=AdminService.selectUserByEmail(email);
	    System.out.println(AdminDTO.toString());
		if(AdminDTO.getPassword().equals(password))
		{
			return true;
		}
	    
		return false;
		
		
	}
/**
 * 
 * @param admin
 */
public void updateByadmin(AdminDTO admin) {
		if(admin==null)
		{
			throw new IllegalArgumentException("错误");
		}
        try {
			JDBCUtils.executeNonQuery("update t_admins set password=? , name=? ,phone=? where email=?", admin.getPassword(),admin.getName(),admin.getPhone(),admin.getEmail());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 
	 * @param admin
	 * @return
	 */
public long addnew(AdminDTO admin) {
		String email=admin.getEmail();
		String password=admin.getPassword();
		String phone=admin.getPhone();
		String name=admin.getName();
        Boolean isDeleted = admin.getIsDeleted();
		try {
			
     	return JDBCUtils.executeInsert("insert into t_admins(email,password,name,phone,isDeleted) values(?,?,?,?,?)",email,password,name,phone,isDeleted);
	
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
select p.* from t_admins u left join t_shopcars s on u.id=s.adminid 
left join t_pets p on s.petsid = p.id where u.id=1
 */

	public void push(Long adminid) {
		try {
			
	     	 JDBCUtils.executeInsert("delete from t_shopcars where adminid=?",adminid);
		
			}
			catch (SQLException e) 
			{
				throw new RuntimeException(e);
			}
	}

	public AdminDTO[] getAll() {
		
			StringBuilder sb = new StringBuilder();
			/*
			 * select a.* from t_admins u left join t_addresses a on u.id=a.adminid where adminid = 1
			 */
			sb.append("select * from t_admins where isDeleted = false");

			List<AdminDTO> list = new ArrayList<>();
			ResultSet rs = null;
			try {
				rs = JDBCUtils.executeQuery(sb.toString());
				while (rs.next()) {
					list.add(toModel(rs));
				}
				return list.toArray(new AdminDTO[list.size()]);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			} finally {
				JDBCUtils.closeAll(rs);
			}

		}

	public AdminDTO selectadminByid(Long id) {
		ResultSet rs = null;
		try
		{
	     	rs=JDBCUtils.executeQuery("select * from t_admins where id=? and  isDeleted =false ",id);

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

	public void delete(AdminDTO admin) {
		
		if(admin==null)
		{
			throw new IllegalArgumentException("错误");
		}
        try {
			JDBCUtils.executeNonQuery("update t_admins set isDeleted =?  where id=?", true,admin.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		

	}


	
}
