package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.UserDTO;
import com.pets.service.UserService;

/**
 * Servlet implementation class passwordChange
 */
@WebServlet("/passwordChange")
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
		//根据id查询出用户
        String email=req.getParameter("email");
        UserService userService=new UserService();
        UserDTO user=userService.selectUserByEmail(email);
		
        String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		
		user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
		/**
		 * 点击修改之后将user重新更新到数据库
		 */
        userService.updateByUser(user);
		
		resp.sendRedirect("./User?action=list");

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
