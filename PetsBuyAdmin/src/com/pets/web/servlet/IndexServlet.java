package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.UserDTO;
import com.pets.service.AdminService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Admin")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	 public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.getRequestDispatcher("/WEB-INF/jsp/adminUser/login.jsp").forward(req, resp);;
	 }
	 public void CheckPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		 AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
			
			AdminService adminService=new AdminService();
			String email=req.getParameter("account");
			String password=req.getParameter("password");
			if(adminService.isExist(email))
			{
				if(adminService.checkLogin(email, password))
				{
                 
					 //保存账号
                    AdminDTO admin=new AdminDTO();
                    
                    admin=adminService.selectUserByEmail(email);
				      
				 	 req.getSession().setAttribute("admin", admin);
				      int maxAge = 60*60*24;//账号保存一天  	
				       //添加cookie 
				      //账号
				      Cookie loginNameCookie = new Cookie("loginName", email);
				      loginNameCookie.setMaxAge(maxAge);//设置过期时间
				      loginNameCookie.setPath("/");
				      resp.addCookie(loginNameCookie);
				      //密码
				      Cookie passwordCookie = new Cookie("password", admin.getPassword());
				      passwordCookie.setMaxAge(maxAge);
				      passwordCookie.setPath("/");
				      resp.addCookie(passwordCookie);
					
					 req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);;
				}			
				else
				{				
					req.setAttribute("message", "登陆失败");
	                req.getRequestDispatcher("/WEB-INF/jsp/adminUser/login.jsp").forward(req, resp);         
					return ;

				}
			}
			else
			{				
				req.setAttribute("message", "登陆失败");
                req.getRequestDispatcher("/WEB-INF/jsp/adminUser/login.jsp").forward(req, resp);         
				return ;

			}

	 
	 }
	 
 public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);;
 }
 public void welcome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
	 req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);;
 }

}
