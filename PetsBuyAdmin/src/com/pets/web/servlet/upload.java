package com.pets.web.servlet;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/upload")
@MultipartConfig
 
 
public class upload extends HttpServlet {
     
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("uploadFile");
        String inputName=part.getName();
        InputStream input=part.getInputStream();
        //想要保存的目标文件的目录下
        String tagDir="/files";
        //避免文件名重复使用uuid来避免,产生一个随机的uuid字符
        String realFileName=UUID.randomUUID().toString();
        OutputStream output=new FileOutputStream(new File(tagDir,realFileName));
        int len=0;
        byte[] buff=new byte[1024*8];
         
        while ((len = input.read(buff)) > -1) {
            output.write(buff, 0, len);
        }
 
        input.close();
        output.close();
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("upload success!!");
     
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
}