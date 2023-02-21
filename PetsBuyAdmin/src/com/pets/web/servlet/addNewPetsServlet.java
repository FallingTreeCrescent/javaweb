package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.PetsDTO;
import com.pets.service.PetsService;

/**
 * Servlet implementation class addNewPetsServlet
 */
@WebServlet("/addNewPets")
public class addNewPetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
      String path= request.getParameter("path");
      String description= request.getParameter("description");
      Float age=Float.parseFloat(request.getParameter("age"));
      String type=request.getParameter("type");
      String name=request.getParameter("name");
      Float sale=Float.parseFloat(request.getParameter("sale"));
      
      PetsDTO pets=new PetsDTO();
      pets.setImage(path);
      pets.setType(type);
      pets.setAge(age);
      pets.setDescription(description);
      pets.setName(name);
      pets.setSale(sale);
      
      /*
       * 执行业务
       */
      PetsService petsService=new PetsService();
      petsService.insert(pets);
      
      
//      response.sendRedirect("./Pets?action=list");
      response.sendRedirect("./Pets?action=list");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
