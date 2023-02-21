package com.pets.service;

import java.util.List;

import com.pets.dao.AddressDAO;
import com.pets.dto.AddressDTO;

public class AddressService {

	
	private AddressDAO dao = new AddressDAO();
	
	public void addnew(AddressDTO addressDto) {
		
	dao.addnew(addressDto);	
		
	}

	public AddressDTO[] selectListAddressByid(Long id) {
     return dao.selectListAddressByid(id);
	}
	
	
	
}
