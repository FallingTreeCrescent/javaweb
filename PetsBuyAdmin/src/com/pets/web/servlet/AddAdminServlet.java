package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.UserDTO;
import com.pets.service.AdminService;
import com.pets.service.UserService;
import com.pets.utls.CommonUtils;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/addAdmin")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
		
		AdminService adminService=new AdminService();
		AdminDTO admin = new AdminDTO();
        String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		 if(!CommonUtils.isEmail(email))
		 {
			 req.setAttribute("message", "邮箱格式不正确");
		     req.getRequestDispatcher("/WEB-INF/jsp/adminUser/add.jsp").forward(req, resp);
				return ;


		 }
		 if(CommonUtils.isEmpty(password))
		 {
			 req.setAttribute("message", "密码不能为空");
		     req.getRequestDispatcher("/WEB-INF/jsp/adminUser/add.jsp").forward(req, resp);
				return ;

			 
		 }
		 if(adminService.isExist(email))
		 {
			 req.setAttribute("message", "该邮箱已经存在");
		     req.getRequestDispatcher("/WEB-INF/jsp/adminUser/add.jsp").forward(req, resp);
				return ;
		 }
		
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		admin.setPhone(phone);
		admin.setIsDeleted(false);
		/**
		 * 点击修改之后将user重新更新到数据库
		 */

		adminService.addnew(admin);
		

		resp.sendRedirect("./adminUser?action=list");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
