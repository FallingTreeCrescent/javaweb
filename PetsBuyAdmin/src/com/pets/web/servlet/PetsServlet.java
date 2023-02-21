package com.pets.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.PetsDTO;
import com.pets.service.OrderService;
import com.pets.service.PetsService;

@WebServlet("/Pets")

public class PetsServlet extends BaseServlet{
	
	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		if(admin2==null)
		{
resp.sendRedirect("/WEB-INF/jsp/adminUser/login.jsp");	
return ;
		}
		//查询出所有的宠物,用品
        PetsService petsService=new PetsService();
        PetsDTO[] petsList=petsService.getAll();
        req.setAttribute("petsList", petsList);        
            
		
		req.getRequestDispatcher("/WEB-INF/jsp/pets/list.jsp").forward(req, resp);;
		 }
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
		if(admin2==null)
		{
	resp.sendRedirect("./adminUser?action=logout");	
	return ;
		}
	   	Long id = (long) Integer.parseInt(req.getParameter("id"));
         PetsService petsService=new PetsService();
         /*
          * 删除
          */
         petsService.delectPetsByid(id);
		 resp.sendRedirect("./Pets?action=list");
	     
		
		
	}
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	   	Long id = (long) Integer.parseInt(req.getParameter("id"));
        PetsService petsService = new PetsService();
        PetsDTO petsDto=petsService.getByPetsId(id);		
		req.setAttribute("petsDto", petsDto);
        req.getRequestDispatcher("/WEB-INF/jsp/pets/update.jsp").forward(req, resp);

	}
	
	
	
	
	
	
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		req.getRequestDispatcher("/WEB-INF/jsp/pets/add.jsp").forward(req, resp);;

		 }
		
}
