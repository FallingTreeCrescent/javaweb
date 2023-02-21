package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.AdminDTO;
import com.pets.dto.EvaluateDTO;
import com.pets.service.AdminService;
import com.pets.service.EvaluateService;

/**
 * Servlet implementation class Answer
 */
@WebServlet("/Answer")
public class Answer extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
	if(admin2==null)
	{
resp.sendRedirect("./adminUser?action=logout");	
return ;
	}
	    EvaluateService evaService =new EvaluateService();
	    EvaluateDTO eva[]=evaService.getAll();
	    req.setAttribute("eva", eva);
		
	    req.getRequestDispatcher("/WEB-INF/jsp/answer/list.jsp").forward(req, resp);;

	}
	public void answer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
	if(admin2==null)
	{
resp.sendRedirect("./adminUser?action=logout");	
return ;
	}
	Long eid=(long) Integer.parseInt(req.getParameter("id"));
	
	req.setAttribute("eid", eid);
    req.getRequestDispatcher("/WEB-INF/jsp/answer/add.jsp").forward(req, resp);;

	}
	public void answerSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	AdminDTO admin2=(AdminDTO) req.getSession().getAttribute("admin");
	if(admin2==null)
	{
resp.sendRedirect("./adminUser?action=logout");	
return ;
	}
	Long eid=(long) Integer.parseInt(req.getParameter("id"));
	String answer =req.getParameter("answer");
	//插入数据到对应的表中
	EvaluateDTO eva=new EvaluateDTO();
	eva.setId(eid);
	eva.setAnswer(answer);
	//
	EvaluateService evaluateService=new EvaluateService();
	evaluateService.addOne(eva, eid);
	

	req.setAttribute("message", "回复成功");
    req.getRequestDispatcher("/WEB-INF/jsp/answer/list.jsp").forward(req, resp);;

	}
	
	
}
