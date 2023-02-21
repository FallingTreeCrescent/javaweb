package com.pets.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.dto.PetsDTO;
import com.pets.service.PetsService;

/**
 * Servlet implementation class UeditorServlet
 */
@WebServlet("/UeditorServlet2")
public class UeditorServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //设置请求和响应的编码统一为UTF-8
	        	Long id = (long) Integer.parseInt(request.getParameter("id"));
     
	           	request.setCharacterEncoding("UTF-8");
		        response.setCharacterEncoding("UTF-8");
		        //拿到编辑器的内容
		        PetsService petsService=new PetsService();
//		        String content = request.getParameter("editorValue");
                PetsDTO petsDto=petsService.getByPetsId(id);
		        String image =request.getParameter("image");
		        String path= request.getParameter("path");
		        String description= request.getParameter("description");
		        Float age=Float.parseFloat(request.getParameter("age"));
		        String type=request.getParameter("type");
		        String name=request.getParameter("name");
		        Float sale=Float.parseFloat(request.getParameter("sale"));
		        
		        //如果不为空
		            //将内容放入数据库

		            PetsDTO pets=new PetsDTO();
		            pets.setId(id);
		            pets.setImage(path);
		            pets.setType(type);
		            pets.setAge(age);
		            pets.setDescription(description);
		            pets.setName(name);
		            pets.setSale(sale);
		            pets.setImage(image);
		            pets.setIsDeleted(false);
		            petsService.update(pets);
		            
		            
		            //转发到content.jsp
		            response.sendRedirect("./Pets?action=list");
		    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
