package com.pets.service;

import java.util.List;

import com.pets.dao.AdminDAO;
import com.pets.dao.UserDAO;
import com.pets.dto.AddressDTO;
import com.pets.dto.AdminDTO;
import com.pets.dto.PetsDTO;

public class AdminService {

	private AdminDAO dao = new AdminDAO();

	public AdminDTO selectUserByEmail(String email)
	{
		
		return dao.getByadminEmail(email);
		
	}

	public void updateByUser(AdminDTO admin) {

		dao.updateByadmin(admin);
		
		
	}

	public boolean checkLogin(String email, String password) {

	 if(dao.checkLogin(email, password))
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	
	
	}
	//判断是否已经存在
	   public boolean isExist(String  email) {
		   AdminDTO ad = dao.getByadminEmail(email);
	       return ad != null  ;
	   }

	public void addnew(AdminDTO admin) {
		
	dao.addnew(admin);	
		
	}

	public  void push(Long id) {

		dao.push(id);
		
	}

	public AdminDTO[] getAll() {

	return dao.getAll();
	}

	public AdminDTO selectUserByid(Long id) {

		return dao.selectadminByid(id);

		

	}

	public void delete(AdminDTO adminDto) {
          
		 dao.delete(adminDto);
		
	}

	

	
	



	

	
	
	
}
