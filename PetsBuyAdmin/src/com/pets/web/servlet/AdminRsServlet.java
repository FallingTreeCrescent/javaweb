package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.service.AdminService;

/**
 * Servlet implementation class AdminRsServlet
 */
@WebServlet("/resetpwd")
public class AdminRsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	     Long id = (long) Integer.parseInt(req.getParameter("id"));

		
			String password=req.getParameter("password");
            
			AdminService adminService=new AdminService();
			AdminDTO admin=adminService.selectUserByid(id);
			
			admin.setPassword(password);
			adminService.updateByUser(admin);

			resp.sendRedirect("./adminUser?action=list");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
