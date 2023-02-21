package com.pets.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.PetsDTO;
import com.pets.dto.PetsToUserDTO;
import com.pets.service.OrderService;
import com.pets.service.PetsToUserService;

@WebServlet("/order")

public class OrderServlet extends BaseServlet{

	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		if(admin2==null)
		{
          resp.sendRedirect("/WEB-INF/jsp/adminUser/login.jsp");	
          return ;
		}
		/*
	 *  查询所有订单并且存入attribute
	 */
	    PetsToUserService petsToUserService=new PetsToUserService();
		PetsToUserDTO[] listPets=petsToUserService.getAll();
	/*
	 * 应该在清空购物车的时候插入数据到数据库
	 */
		req.setAttribute("listPets", listPets);
		req.getRequestDispatcher("/WEB-INF/jsp/order/list.jsp").forward(req, resp);;
	 }
	public void fahuo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
		Long id = (long) Integer.parseInt(req.getParameter("id"));
	    PetsToUserService petsToUserService=new PetsToUserService();
        petsToUserService.fahuo(id);
        req.setAttribute("message", "订单"+id+":发货成功");
        req.getRequestDispatcher("/WEB-INF/jsp/order/list.jsp").forward(req, resp);
        return ;
		
	}
	
}
