package com.pets.service;

import com.pets.dao.EvaluateDAO;
import com.pets.dto.EvaluateDTO;
import com.pets.dto.UserDTO;

public class EvaluateService {
private EvaluateDAO dao=new EvaluateDAO();
	
/**
 * 插入业务
 * @param evaluateDTO
 * @param userDto
 */
	public void insert(Long petsId,EvaluateDTO evaluateDTO,UserDTO userDto)
	{
		dao.addnew(userDto, evaluateDTO,petsId);
		
		
	}

public EvaluateDTO[] getAllbyPetsId(Long id) {
	// TODO Auto-generated method stub
return dao.getAllbyPetsId(id);
}

public EvaluateDTO[] getAll() {

return dao.getAll();

}

public void addOne(EvaluateDTO evaluateDTO,Long id) {
dao.update(evaluateDTO, id);
}


//    }

}
