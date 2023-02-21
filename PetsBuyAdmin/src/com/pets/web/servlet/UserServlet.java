package com.pets.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.pets.dto.AdminDTO;
import com.pets.dto.UserDTO;
import com.pets.service.UserService;

@WebServlet("/User")
public class UserServlet extends BaseServlet{

	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		if(admin2==null)
		{

        resp.sendRedirect("/WEB-INF/jsp/adminUser/login.jsp");	
         return ;
		}
		//获得所有用户
		UserService userService=new UserService();
		UserDTO userList[]=userService.getAll();
		
		
		req.setAttribute("userList", userList);
	    req.getRequestDispatcher("/WEB-INF/jsp/user/list.jsp").forward(req, resp);;

	}
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		if(admin2==null)
		{
	resp.sendRedirect("./adminUser?action=logout");	
	return ;
		}
		//获得id的值
		//通过id来查询出user
	     Long id = (long) Integer.parseInt(req.getParameter("id"));
         UserService userService=new UserService();
         UserDTO user = userService.selectUserByid(id);
        
         
        req.setAttribute("user", user);
       
	    req.getRequestDispatcher("/WEB-INF/jsp/user/update.jsp").forward(req, resp);

	}
	public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		if(admin2==null)
		{
	resp.sendRedirect("./adminUser?action=logout");	
	return ;
		}	
		Long id = (long) Integer.parseInt(req.getParameter("id"));
        UserService userService=new UserService();
        UserDTO user=userService.selectUserByid(id);
      
        req.setAttribute("user", user);
      
	    req.getRequestDispatcher("/WEB-INF/jsp/user/show.jsp").forward(req, resp);
	}

	
}
