package com.pets.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.UserDTO;
import com.pets.service.AdminService;
import com.pets.service.UserService;

@WebServlet("/adminUser")

public class AdminUserServlet extends BaseServlet{

	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
	if(admin2==null)
	{
        resp.sendRedirect("/WEB-INF/jsp/adminUser/login.jsp");	
         return ;
	}
		AdminService adminService=new AdminService();
		AdminDTO adminList[]=adminService.getAll();
		
		
		req.setAttribute("adminList", adminList);
	    req.getRequestDispatcher("/WEB-INF/jsp/adminUser/list.jsp").forward(req, resp);;

	}

	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
	
		if(admin2==null)
		{
	resp.sendRedirect("./adminUser?action=logout");	
	return ;
		}
		  req.getRequestDispatcher("/WEB-INF/jsp/adminUser/add.jsp").forward(req, resp);
		
		
	}
//	logout
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		  //销毁数据
		   req.getSession().invalidate();
		   int maxAge=0;
		   Cookie loginNameCookie = new Cookie("loginName", "");
	       loginNameCookie.setMaxAge(maxAge);
	       loginNameCookie.setPath("/");
	       resp.addCookie(loginNameCookie);

	       Cookie passwordCookie = new Cookie("password", "");
	       passwordCookie.setMaxAge(maxAge);
	       passwordCookie.setPath("/");
	       resp.addCookie(passwordCookie);
		   
		 req.getRequestDispatcher("/WEB-INF/jsp/adminUser/login.jsp").forward(req, resp);
		
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
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	
	{
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
		if(admin2==null)
		{
	resp.sendRedirect("./adminUser?action=logout");	
	return ;
		}
		Long id = (long) Integer.parseInt(req.getParameter("id"));
		AdminService adminService=new AdminService();
		AdminDTO adminDto=adminService.selectUserByid(id);
		//使用软删除
		adminService.delete(adminDto);
		resp.sendRedirect("./adminUser?action=list");	
		
	}
//	reset
	public void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
		
		Long id = (long) Integer.parseInt(req.getParameter("id"));
		AdminService adminService=new AdminService();
		AdminDTO admin=adminService.selectUserByid(id);
		
		
		req.setAttribute("admin", admin);
		req.getRequestDispatcher("/WEB-INF/jsp/adminUser/resetPassword.jsp").forward(req, resp);	
	   
	}

	
}
