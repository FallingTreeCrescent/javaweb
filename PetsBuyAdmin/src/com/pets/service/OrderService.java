package com.pets.service;

import java.util.List;

import org.apache.logging.log4j.core.config.Order;

import com.pets.dao.OrderDAO;
import com.pets.dto.OrderDTO;

public class OrderService {

private OrderDAO OrderDao=new OrderDAO();	
	public long addnew(Long userId,Long petsId)
	{
		return OrderDao.addnew(userId, petsId);
		
	}
	public void strage(Long userid) {

	 OrderDao.strage(userid);
		
	}
	public OrderDTO[] getall() {


		return OrderDao.getAll();
	}
	
	
}
